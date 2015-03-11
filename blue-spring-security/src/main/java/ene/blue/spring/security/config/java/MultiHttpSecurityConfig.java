package ene.blue.spring.security.config.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER")
		.and()
		.withUser("admin").password("password").roles("ADMIN", "USER");
	}
	
	/***
	 * @order 指定的WebSecurityConfigurerAdapter表示被认为的第一个
	 * 
	 * 以/api/开始的URL需要验证
	 * 
	 * @author zhangrui
	 */
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http
				.antMatcher("/api/**").authorizeRequests()
				.anyRequest().hasRole("ADMIN")
				.and()
				.httpBasic();
		}
	}
	
	/**
	 * 非/api/开始的URL无需验证
	 * @author zhangrui
	 *
	 */
	@Configuration
	public static class FromLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin();
		}
	}
	
	@Configuration
	public static class PostProcessWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http
				.authorizeRequests()
				.anyRequest().authenticated()
				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					public <O extends FilterSecurityInterceptor> O postProcess(O fsi){
						fsi.setPublishAuthorizationSuccess(true);
						return fsi;
					}
				});
		}
	}
	
	
}
