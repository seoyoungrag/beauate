package com.beauate.ceo.common.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.access.servlet.TeeFilter;
import ch.qos.logback.access.tomcat.LogbackValve;

@Configuration
public class FilterConfiguration {
	@Bean
	public TomcatServletWebServerFactory servletContainer() {
	    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
	    tomcat.addContextValves(new LogbackValve());
	    return tomcat;
	}
	
    @Autowired
    @Bean
    public FilterRegistrationBean requestResponseFilter() {

        final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        TeeFilter filter = new TeeFilter();
        filterRegBean.setFilter(filter);
        filterRegBean.addUrlPatterns("/api/*");
        filterRegBean.setName("Request Response Filter");
        filterRegBean.setAsyncSupported(Boolean.TRUE);
        return filterRegBean;
    }
}
