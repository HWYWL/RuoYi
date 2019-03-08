package com.ruoyi.web.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis扫描配置
 * @author YI
 * @date 2019-3-8 15:21:01
 */
@Configuration
@MapperScan("com.ruoyi.*.mapper")
public class MyBatisConfig {

}
