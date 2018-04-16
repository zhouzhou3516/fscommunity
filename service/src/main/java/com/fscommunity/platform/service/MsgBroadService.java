package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.MsgBroadMapper;
import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-14
 */
@Service
public class MsgBroadService {
    @Autowired
    MsgBroadMapper msgBroadMapper;

    /**
     * 保存留言板消息，id会回写
     * @param msgBroad 要保存的留言板消息
     * @return 返回保存后的留言板消息
     */
    public MsgBroad saveBroad(MsgBroad msgBroad) {
        Preconditions.checkNotNull(msgBroad);
        msgBroadMapper.insert(msgBroad);
        return msgBroad;
    }

    public MsgBroad queryById(int id) {
        return msgBroadMapper.queryById(id);
    }

    public int updateTreeCode(int id,String treecode) {
        return msgBroadMapper.updateTreeCode(id, treecode);
    }
}
