package ene.blue.spring.security.config.java;

public class SecurityConfigFactory {
	
	public static Class<?> instance(){
		Class<?> cls = null;
		cls = SecurityInMemoryConfig.class;
		return cls;
	}
	
}
