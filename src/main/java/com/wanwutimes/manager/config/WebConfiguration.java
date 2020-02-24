package com.wanwutimes.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Description: 消息转换器
 * @Author: yxp
 * @CreateDate: 2020-02-20 18:15
 * @Version: 1.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0,new MappingJackson2HttpMessageConverter());
	}
}
