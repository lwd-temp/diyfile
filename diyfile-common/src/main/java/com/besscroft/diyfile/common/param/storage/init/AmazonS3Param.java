package com.besscroft.diyfile.common.param.storage.init;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description Amazon S3 初始化参数
 * @Author Bess Croft
 * @Date 2023/3/10 23:32
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class AmazonS3Param extends S3Param {

    /** 访问密钥 */
    private String accessKey;

    /** 机密密钥 */
    private String secretKey;

    /** 地域 */
    private String region;

    /** endpoint 端点 */
    private String endpoint;

}
