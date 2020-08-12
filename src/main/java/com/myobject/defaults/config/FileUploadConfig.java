package com.myobject.defaults.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import lombok.extern.log4j.Log4j;

@Configuration
@Log4j
public class FileUploadConfig {

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// 10MB
		int maxSize = (1024*1024*10);
		resolver.setMaxUploadSize(maxSize);
		// 1MB
		int memorySize = (1024*1024*1);
		resolver.setMaxInMemorySize(memorySize);;
		// MacOS Path
		String dirPath = "/Users/harry/Desktop/MY_PROJECT/MYOBJECT/upload";
		resolver.setUploadTempDir(new FileSystemResource(dirPath));
		String encoding = "UTF-8";
		resolver.setDefaultEncoding(encoding);
		return resolver;
	}
}
