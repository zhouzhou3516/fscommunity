package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.MsgBroadMapper;
import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liqingzhou on 18/4/30.
 */
@Service
public class MsgBroadService {

    @Autowired
    MsgBroadMapper msgBroadMapper;

    /**
     * 保存留言板消息，id会回写
     *
     * @param msgBroad 要保存的留言板消息
     * @return 返回保存后的留言板消息
     */
    public MsgBroad saveBroad(MsgBroad msgBroad) {
        Preconditions.checkNotNull(msgBroad);
        msgBroadMapper.insert(msgBroad);
        return msgBroad;
    }

    public int updateIsReplied(int id) {
        return msgBroadMapper.updateIsReplied(id);
    }

    /**
     * \
     *
     * @param authStatus -1 表示查所有状态
     * @param replyStatus -1 表示查所有状态
     */
    public List<MsgBroad> list(int authStatus, int replyStatus, PageRequest pageRequest) {
        return msgBroadMapper
                .list(authStatus, replyStatus, new RowBounds(pageRequest.getOffset(), pageRequest.getLimit()));
    }

    public int countList(Integer authStatus, Integer replyStatus) {
        return msgBroadMapper.countList(authStatus, replyStatus);
    }

    @Transactional
    public void updateTreeCode(boolean newMsg, MsgBroad savedBroad) {
        lockForUpdateInTransaction(savedBroad.getId());
        String treecode;
        if (newMsg) {
            treecode = "0#" + savedBroad.getId() + "#";
        } else {
            MsgBroad pmsg = queryById(savedBroad.getTargetCid());
            treecode = pmsg.getTreecode() + savedBroad.getId() + "#";
        }
        updateTreeCode(savedBroad.getId(), savedBroad.getTreecode());
    }

    public MsgBroad queryById(int id) {
        return msgBroadMapper.queryById(id);
    }

    private int updateTreeCode(int id, String treecode) {
        return msgBroadMapper.updateTreeCode(id, treecode);
    }

    public void lockForUpdateInTransaction(int id) {
        msgBroadMapper.lockForUpdate(id);
    }


    public void updateAuthStatus(int commentId, int code) {

    }

    public List<MsgBroad> queryByRootCId(int rootCid, PageRequest pageRequest) {
        return msgBroadMapper.queryByRootCId(rootCid, new RowBounds(pageRequest.getOffset(), pageRequest.getLimit()));
    }

    public List<MsgBroad> wxlist(PageRequest pageRequest) {
        return msgBroadMapper.wxlist(new RowBounds(pageRequest.getOffset(), pageRequest.getLimit()));
    }

    public List<MsgBroad> queryReplyByRootCids(List<Integer> ids) {

        List<MsgBroad> msgBroads = msgBroadMapper.queryReplyByRootCids(ids);
        if (CollectionUtils.isEmpty(msgBroads)) {
            return Lists.newArrayList();
        }
        return msgBroads;
    }
}
