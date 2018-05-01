package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.adapter.AnnouncementAdapter;
import com.fscommunity.platform.provider.backoffice.req.AddAnnounceReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrAnnouncementItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrAnnouncementListVo;
import com.fscommunity.platform.service.AnnouncementService;
import com.fscommunity.platform.service.ArticleService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.util.pojo.FuzzyNameListQueryReq;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/4/29
 */
@Component
@RequestMapping("/fscommunity/man/announce")
public class MgrAnnouncementController {


    @Resource
    private AnnouncementService announcementService;
    @Resource
    private ArticleService articleService;

    //both support update save
    @RequestMapping("/save")
    @JsonBody
    public void addPhone(@RequestBody AddAnnounceReq req) {
        Article article = articleService.selectById(req.getArticleId());
        if (article == null) {
            throw new BizException("文章链接不存在");
        }
        if(req.getArticleId()<=0) {
            announcementService.saveAnnouncement(AnnouncementAdapter.adaptToInfo(req));
        }else{
            announcementService.updateAnnouncement(AnnouncementAdapter.adaptToInfo(req));
        }
    }

    @RequestMapping("/list")
    @JsonBody
    public MgrAnnouncementListVo queryPhoneList(@RequestBody FuzzyNameListQueryReq req) {
        List<AnnouncementInfo> announcementInfoList = announcementService
                .list(req.getFuzzyName(), new PageRequest(req.getCurrentPage(), req.getPageSize()));

        MgrAnnouncementListVo vo = new MgrAnnouncementListVo();
        if (CollectionUtils.isEmpty(announcementInfoList)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
            return vo;
        }
        List<Integer> aids = announcementInfoList.stream().map(info -> Integer.valueOf(info.getArticleId()))
                .collect(Collectors.toList());
        List<Article> articleList = articleService.selectByIds(aids);
        Map<Integer, Article> articleMap = articleList.stream().collect(Collectors.toMap(a -> a.getId(), a -> a));
        List<MgrAnnouncementItemVo> listVos = AnnouncementAdapter.adaptItemVos(announcementInfoList, articleMap);
        vo.setCount(announcementService.countAnnouncement(req.getFuzzyName()));
        vo.setItems(listVos);
        return vo;
    }


    @RequestMapping("/del")
    @JsonBody
    public void delPhone(int id) {
        announcementService.del(id);
    }
}
