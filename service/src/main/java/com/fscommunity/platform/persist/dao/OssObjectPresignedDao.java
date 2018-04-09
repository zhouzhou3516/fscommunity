package com.fscommunity.platform.persist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fscommunity.platform.persist.pojo.OssObjectPresignedUrlnfo;

/**
 * @author chao.zhu
 * @version 2018-04-09
 */
@Repository
public interface OssObjectPresignedDao {
    int saveOssObPresignedUrl(OssObjectPresignedUrlnfo info);
    OssObjectPresignedUrlnfo queryByObjectName(@Param("bucketName") String bucketName,
    @Param("objectName") String objectName);
}
