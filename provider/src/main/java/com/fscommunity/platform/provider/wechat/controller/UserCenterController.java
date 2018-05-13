package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.common.util.UserIntergralCalulator;
import com.fscommunity.platform.common.util.UserLevelCalulator;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.*;
import com.fscommunity.platform.provider.wechat.req.UserAuthReq;
import com.fscommunity.platform.provider.wechat.vo.SignResultVo;
import com.fscommunity.platform.provider.wechat.vo.UserAuthVo;
import com.fscommunity.platform.provider.wechat.vo.UserDetailVo;
import com.fscommunity.platform.provider.wechat.voadaptor.UserAuthApplyAdapter;
import com.fscommunity.platform.provider.wechat.voadaptor.UserInfoVoAdaptor;
import com.fscommunity.platform.service.UserAuthApplyService;
import com.fscommunity.platform.service.UserInfoService;
import com.fscommunity.platform.service.UserSignInfoService;
import com.fscommunity.platform.service.WxUserService;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.util.pojo.APIResponse;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@RequestMapping("/fscommunity/user")
@Controller
public class UserCenterController {

    @Resource
    UserInfoService userInfoService;
    @Resource
    UserSignInfoService userSignInfoService;
    @Resource
    SessionHolder sessionHolder;
    @Resource
    UserAuthApplyService authApplyService;
    @Resource
    WxUserService wxUserService;


    /**
     * 用户中心信息详情
     *
     * @return 返回当前验证用户
     */
    @RequestMapping("/detail")
    @JsonBody
    public UserDetailVo queryUserDetail() {
        SessionUserInfo user = sessionHolder.currentUser();
        UserInfo userInfo = userInfoService.queryUserById(user.getUserId());
       // WxUser wxUser = wxUserService.queryWxUserByOpenid(user.getOpenId());
        return UserInfoVoAdaptor.adaptToDetailVo(userInfo);
    }

    /**
     * 用户签到
     */
    @RequestMapping("/sign")
    @JsonBody
    public SignResultVo userSign() {
        SessionUserInfo info = sessionHolder.currentUser();
        //1. 校验今日签名是否完成
        UserSignInfo staffSignInfo = userSignInfoService
                .queryStaffSign(1, DateFormatUtil.format4y2M2d(new Date()));
        if (staffSignInfo != null) {
            throw new BizException("今天已经签到完成");
        }

        //2. 如果么有签名,则签名,并记录
        UserSignInfo signInfo = buildSign(info.getUserId(), checkContinuous(info.getUserId()));
        userSignInfoService.saveUserSign(signInfo);

        //3. 增加积分
        UserInfo currentInfo = userInfoService.queryUserById(info.getUserId());
        int newIntegral = currentInfo.getBizInfo().getIntegral() + signInfo.getEarnIntegral();
        userInfoService.updateIntegralByUserId(currentInfo.getId(), newIntegral);

        UserLevel userLevel = UserLevelCalulator.checkLevel(newIntegral);
        userInfoService.updateUserLevel(currentInfo.getId(), userLevel);

        //4. 构建返回结果
        SignResultVo vo = new SignResultVo();
        vo.setIntegral(newIntegral);
        vo.setLevel(userLevel.name());
        vo.setAddIntegral(signInfo.getEarnIntegral());
        vo.setContinuous(signInfo.getFinishConDays());
        return vo;
    }

    private UserSignInfo buildSign(int userId, int continuous) {
        Date current = new Date();
        UserSignInfo signInfo = new UserSignInfo();
        signInfo.setCreateTime(current);
        signInfo.setUpdateTime(current);
        signInfo.setDayTime(DateFormatUtil.format4y2M2d(new Date()));
        signInfo.setEarnIntegral(UserIntergralCalulator.addIntegral(continuous + 1));
        signInfo.setUserId(userId);
        signInfo.setContinuous(continuous > 0);
        signInfo.setFinishConDays(continuous + 1);
        return signInfo;
    }

    /**
     * 判断是否连续签到
     *
     * @param userId 会员id
     * @return 返回已连续签到天数, 返回值-1代表没有连续签到, n代表已连续签到n天
     */
    private int checkContinuous(int userId) {
        int countStaffSign = userSignInfoService.countStaffSign(userId);
        if (countStaffSign == 0) {
            return 0;
        }

        Date yesterday = DateUtils.addDays(new Date(), -1);
        UserSignInfo signInfo = userSignInfoService
                .queryStaffSign(userId, DateFormatUtil.format4y2M2d(yesterday));
        if (signInfo != null) {
            return signInfo.getFinishConDays();
        }
        return 0;
    }

    @RequestMapping("authApply")
    @JsonBody
    @Transactional(rollbackFor = Throwable.class)
    public APIResponse<UserAuthVo> auth(@RequestBody  UserAuthReq req) {
        UserInfo user = userInfoService.queryByIdCard(req.getIdCard());
        if (user == null) {
            throw new BizException("没有您的信息,不能认证");
        }
        if(user.getAuditStatus() == UserAuditStatus.AUDITED){
            throw new BizException("已经审核过，无需重复审核");
        }
        if(user.getAuditStatus() == UserAuditStatus.NOT_PASS){
            return APIResponse.error(102, "您审核未通过");
        }
        if(user.getAuditStatus() == UserAuditStatus.UN_AUDIT){
            throw new BizException("审核中，请等待");
        }
        UserAuthApply apply = UserAuthApplyAdapter.adapter(req);
        UserAuthVo vo = UserAuthApplyAdapter.adapterToVo(req);

        if (!bizCheck(user, req)) {
            apply.setAuditStatus(UserAuditStatus.UN_AUDIT);
            authApplyService.save(apply);
            user.setAuditStatus(UserAuditStatus.UN_AUDIT);
            userInfoService.saveUserInfo(user);
            vo.setUserAuditStatus(UserAuditStatus.UN_AUDIT);
            return APIResponse.success(vo);
        }
        String openId = sessionHolder.currentOpenId();
        WxUser wxUser = wxUserService.queryWxUserByOpenid(openId);
        user.setOpenId(openId);
        UserBaseinfo baseinfo = user.getBaseinfo();
        baseinfo = updateBaseInfo(baseinfo,wxUser);
        user.setBaseinfo(baseinfo);
        user.setAuditStatus(UserAuditStatus.AUDITED);
        userInfoService.saveUserInfo(user);
        vo.setUserAuditStatus(UserAuditStatus.AUDITED);
        return APIResponse.success(vo);
    }

    private UserBaseinfo updateBaseInfo(UserBaseinfo baseinfo, WxUser wxUser) {
        baseinfo.setWxNickName(wxUser.getNickname());
        baseinfo.setAvatarUrl(wxUser.getHeadimgurl());
        return baseinfo;
    }

    private boolean bizCheck(UserInfo user, UserAuthReq req) {
        if (StringUtils.equals(req.getRealName(), user.getRealName())
                && StringUtils.equals(req.getStreet(), user.getStreat())
                && StringUtils.equals(req.getCommunity(), user.getCommunity())
                && StringUtils.equals(req.getBuilding(), user.getBuilding())
                && StringUtils.equals(req.getUnit(), user.getUnit())
                && StringUtils.equals(req.getRoom(), user.getRoom())
                ) {
            return true;
        }
        return false;
    }


}
