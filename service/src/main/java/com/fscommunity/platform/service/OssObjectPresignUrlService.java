package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.OssObjectPresignedDao;
import com.fscommunity.platform.persist.pojo.OssObjectPresignedUrlnfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chao.zhu
 * @version 2018-04-09
 */
@Service
public class OssObjectPresignUrlService {

    @Resource
    OssObjectPresignedDao ossObjectPresignedDao;


    public int saveOssObjectUrl(OssObjectPresignedUrlnfo info) {
        return ossObjectPresignedDao.saveOssObPresignedUrl(info);
    }

    public OssObjectPresignedUrlnfo queryByBNameAndObName(String bucketName, String object) {
        return ossObjectPresignedDao.queryByObjectName(bucketName, object);
    }
}
