package com.excersise.shortestroute.commons.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application")
@PropertySource("classpath:exception.properties")
public class ApplicationExceptionProperties {
	
	private Map<String, String> exception = new HashMap<String, String>();

	public Map<String, String> getException() {
		return exception;
	}

	public void setException(Map<String, String> exception) {
		this.exception = exception;
	}
	
}
