package com.beauate.core.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class JsonViewConfig {

	@Bean
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}
	@Bean
	public BeanNameViewResolver bnViewResolver() {
		BeanNameViewResolver bean = new BeanNameViewResolver();
		bean.setOrder(0);
		return bean;
	}
}
