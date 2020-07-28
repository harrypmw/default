package com.myobject.defaults.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.myobject.defaults.*"})
public class RootConfig {

}
