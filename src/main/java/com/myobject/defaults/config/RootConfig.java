package com.myobject.defaults.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.myobject.*"})
@Import({PropertyConfig.class, DataSourceConfig.class,
		 MyBatisConfig.class, FileUploadConfig.class})
public class RootConfig {

}
