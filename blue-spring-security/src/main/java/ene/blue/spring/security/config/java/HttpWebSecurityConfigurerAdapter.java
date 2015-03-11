package ene.blue.spring.security.config.java;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class HttpWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			/* 所有的用户都可以接入以/resources/开头的URl，同时可以接入/singup、 /about等URL */
			.antMatchers("/resources/**", "/singup", "/about").permitAll()
			/* 用户ROLE_ADMIN权限的用户可以使用/admin/**的URL */
			.antMatchers("/admin/**").hasRole("ADMIN")
			/* 使用/db/**的用户必须有ROLE_ADMIN和ROLE_DBA权限 */
			.antMatchers("/db/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
			.anyRequest().authenticated()
			.and()
			/* 对所有用户的/login添加验证 */
			.formLogin().loginPage("/login").permitAll()
			.and().httpBasic();
	}
	
}
