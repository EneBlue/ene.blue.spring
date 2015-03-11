package ene.blue.spring.security.config.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * LDAP是轻量目录访问协议，Lightweight Directory Access Protocol
 * 它是基于X.500标准
 * @author zhangrui
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityLdapConfig extends HttpWebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people")
			.groupSearchBase("ou=groups");
	}
}
