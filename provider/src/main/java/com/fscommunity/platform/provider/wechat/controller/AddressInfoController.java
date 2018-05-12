package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.CommunityInfo;
import com.fscommunity.platform.provider.wechat.vo.LabelVo;
import com.fscommunity.platform.service.UserInfoService;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
@Controller
@RequestMapping("/fscommunity/wechat/address")
public class AddressInfoController {

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/streats")
    @JsonBody
    public List<String> queryAllStreat() {
        return userInfoService.queryAllStreats();
    }

    @RequestMapping("/comms")
    @JsonBody
    public List<LabelVo> queryCommunityByStreat(String streat) {
        List<CommunityInfo> infoList = userInfoService.queryCommunityByStreat(streat);
        if (CollectionUtils.isEmpty(infoList)) {
            return new ArrayList<LabelVo>() {
            };
        }

        Multimap<String, String> streatCommMap = ArrayListMultimap.create();
        Multimap<String, String> commBuildingMap = ArrayListMultimap.create();
        Multimap<String, String> buildingUnitMap = ArrayListMultimap.create();
        Multimap<String, String> unitRoomMap = ArrayListMultimap.create();

        for (CommunityInfo info : infoList) {
            streatCommMap.put(streat, info.getCommunityName());
            commBuildingMap.put(info.getCommunityName(), info.getBuildNum());
            buildingUnitMap.put(info.getBuildNum(), info.getUnitNum());
            unitRoomMap.put(info.getUnitNum(), info.getRoomNum());
        }

        //1. unit
        Map<String, LabelVo> unitsMap = new HashMap<>();
        for (String key : unitRoomMap.keySet()) {
            LabelVo unit = new LabelVo();
            unit.setLabel(key);
            unit.setValue(key);

            Collection<String> rooms = unitRoomMap.get(key);
            for (String room : rooms) {
                LabelVo roomLabel = new LabelVo();
                roomLabel.setValue(room);
                roomLabel.setLabel(room);
                unit.getSubLabels().add(roomLabel);
            }
            unitsMap.put(key, unit);
        }

        //2. build
        Map<String, LabelVo> buildsMap = new HashMap<>();
        for (String key : buildingUnitMap.keySet()) {
            LabelVo building = new LabelVo();
            building.setLabel(key);
            building.setValue(key);

            Collection<String> units = buildingUnitMap.get(key);
            for (String unit : units) {
                building.getSubLabels().add(unitsMap.get(unit));
            }
            buildsMap.put(key, building);
        }

        //3. comm
        Map<String, LabelVo> commsMap = new HashMap<>();
        for (String key : commBuildingMap.keySet()) {
            LabelVo comm = new LabelVo();
            comm.setLabel(key);
            comm.setValue(key);

            Collection<String> builds = commBuildingMap.get(key);
            for (String unit : builds) {
                comm.getSubLabels().add(buildsMap.get(unit));
            }

            commsMap.put(key, comm);
        }

        Map<String, LabelVo> streatsMap = new HashMap<>();
        for (String key : streatCommMap.keySet()) {
            LabelVo streatLabel = new LabelVo();
            streatLabel.setLabel(key);
            streatLabel.setValue(key);

            Collection<String> comms = streatCommMap.get(key);
            for (String comm : comms) {
                streatLabel.getSubLabels().add(commsMap.get(comm));
            }

            streatsMap.put(key, streatLabel);
        }


       return Lists.newArrayList(streatsMap.values());
    }
}
