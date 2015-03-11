package ene.blue.spring.ldap;

import javax.naming.NamingException;

import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.DirContextAdapter;

public class PersonContextMapper implements ContextMapper<Object>{

	@Override
	public Object mapFromContext(Object dir) throws NamingException {
		
		@SuppressWarnings("unused")
		DirContextAdapter context = (DirContextAdapter) dir;
		
		
		return null;
	}

}
