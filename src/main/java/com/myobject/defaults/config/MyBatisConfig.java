package com.myobject.defaults.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.myobject.*.mapper"})
public class MyBatisConfig {

}
