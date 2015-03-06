package ene.blue.spring.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import ene.blue.spring.security.config.java.SecurityConfigFactory;

/**
 * 本类的作用为：
 * 
 * Antomatically register the springSecurityFilterChain Filter 
 * for every URL in your application.
 * 
 * Add a ContextLoaderListener that loads the SecurityConfig.
 * 
 * @author zhangrui
 *
 */
public class SecurityWebApplicationInitializer 
	extends AbstractSecurityWebApplicationInitializer{
	
	public SecurityWebApplicationInitializer(){
		super(SecurityConfigFactory.instance());
	}
}
