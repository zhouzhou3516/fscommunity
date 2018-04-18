package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.VoteItemMapper;
import com.fscommunity.platform.persist.pojo.VoteItem;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Service
public class NetVoteItemService {

    @Resource
    VoteItemMapper voteItemMapper;

    public VoteItem addNewItem(VoteItem item) {
        voteItemMapper.insert(item);
        return item;
    }

    public List<VoteItem> addNewItems(List<VoteItem> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        for (VoteItem item : items) {
            addNewItem(item);
        }
        return items;
    }

    public List<VoteItem> queryItemsByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.EMPTY_LIST;
        }

        return voteItemMapper.queryItemsByIds(ids);
    }

    public List<VoteItem> queryItemsByVoteId(int voteId) {
        return voteItemMapper.queryItemsByVoteId(voteId);
    }

    @Transactional
    public void voteOnce(int id) {
        //锁住记录
        voteItemMapper.lockForLock(id);
        VoteItem voteItem = voteItemMapper.selectById(id);
        voteItemMapper.updateCountById(id, voteItem.getVoterSum() +1);
    }

    public int delVoteItem(int itemId) {
        return voteItemMapper.deleteById(itemId);
    }

    public int delVoteItems(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }

        for (Integer id : ids) {
            delVoteItem(id);
        }
        return ids.size();
    }
}
