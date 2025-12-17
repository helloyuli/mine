package com.pinkitec.aps.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SnowTebuflakeUtils implements InitializingBean {
    /**
     * 工作机器ID(0~31)
     */
    @Value("${snowflake.worker.id}")
    private Long workerId;

    /**
     * 数据中心ID(0~31)
     */
    @Value("${snowflake.datacenter.id}")
    private Long datacenterId;

    /**
     * 业务主键标识
     */
    @Value("${snowflake.bussign.id}")
    private String pkIdSign;

    public static Snowflake snowflake;
    public static String snowflakePkIdSign;

    /**
     * 初始化配置参数
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        snowflakePkIdSign = pkIdSign;
    }
}
