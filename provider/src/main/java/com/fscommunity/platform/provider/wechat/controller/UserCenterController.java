package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.util.UserIntergralCalulator;
import com.fscommunity.platform.common.util.UserLevelCalulator;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.UserLevel;
import com.fscommunity.platform.persist.pojo.UserSignInfo;
import com.fscommunity.platform.provider.wechat.vo.SignResultVo;
import com.fscommunity.platform.provider.wechat.vo.UserDetailVo;
import com.fscommunity.platform.provider.wechat.voadaptor.UserInfoVoAdaptor;
import com.fscommunity.platform.service.UserInfoService;
import com.fscommunity.platform.service.UserSignInfoService;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Date;
import javax.annotation.Resource;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


    /**
     * 用户中心信息详情
     * @return 返回当前验证用户
     */
    @RequestMapping("/detail")
    @JsonBody
    public UserDetailVo queryUserDetail() {
        //todo 从上下文中获取当前用户
        UserInfo userInfo = userInfoService.queryUserById(1);
        return UserInfoVoAdaptor.adaptToDetailVo(userInfo);
    }

    /**
     * 用户签到
     */
    @RequestMapping("/sign")
    @JsonBody
    public SignResultVo userSign() {
        //todo 从上下文中获取当前用户
        //UserInfo info = sessionUserHolder.currentStaff();
        UserInfo info = null;
        //1. 校验今日签名是否完成
        UserSignInfo staffSignInfo = userSignInfoService
                .queryStaffSign(1, DateFormatUtil.format4y2M2d(new Date()));
        if (staffSignInfo != null) {
            throw new BizException("今天已经签到完成");
        }

        //2. 如果么有签名,则签名,并记录
        UserSignInfo signInfo = buildSign(info.getId(), checkContinuous(info.getId()));
        userSignInfoService.saveUserSign(signInfo);

        //3. 增加积分
        UserInfo currentInfo = userInfoService.queryUserById(info.getId());
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
     * @param userId 会员id
     * @return 返回已连续签到天数,返回值-1代表没有连续签到, n代表已连续签到n天
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
}
