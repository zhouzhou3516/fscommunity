package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.MsgBroadMapper;
import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-14
 */
public class MsgBroadService {
    @Autowired
    MsgBroadMapper msgBroadMapper;

    public List<MsgBroad> list(String condition, PageRequest pageRequest) {

        List<MsgBroad> msgBroadList = msgBroadMapper.list(condition,
                new RowBounds(pageRequest.getOffset(),pageRequest.getLimit())
        );
        for(MsgBroad msgBroad: msgBroadList){
            msgBroad.setContent(Base64Util.encode(msgBroad.getContent()));
        }
        return msgBroadList;
    }

    public void add(MsgBroad msgBroad) {
        Preconditions.checkNotNull(msgBroad);
        msgBroad.setContent(Base64Util.encode(msgBroad.getContent()));
        msgBroad.setPublishTime(new Date());
        msgBroadMapper.insert(msgBroad);
    }

    public MsgBroad selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        MsgBroad msgBroad = msgBroadMapper.selectById(Integer.valueOf(id));
        msgBroad.setContent(Base64Util.decode(msgBroad.getContent()));
        return msgBroad;
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        msgBroadMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(MsgBroad msgBroad) {
        Preconditions.checkNotNull(msgBroad);
        msgBroad.setContent(Base64Util.encode(msgBroad.getContent()));
        msgBroadMapper.updateById(msgBroad);
    }

    public int getCount() {
        return msgBroadMapper.getCount();
    }

    public int displayMsg(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        return msgBroadMapper.displayMsg(Integer.valueOf(id));
    }
}
