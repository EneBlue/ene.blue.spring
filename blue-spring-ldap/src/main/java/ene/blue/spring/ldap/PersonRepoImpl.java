package ene.blue.spring.ldap;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

public class PersonRepoImpl {
	private LdapTemplate ldapTemplate;
	
	public void setLadpTemplate(LdapTemplate ldapTemplate){
		this.ldapTemplate = ldapTemplate;
	}
	
	public List<String> getAllPersonNames(){
		return ldapTemplate.search(
				query().where("objectclass").is("person"), 
				new AttributesMapper<String>() {
					@Override
					public String mapFromAttributes(Attributes attr)
							throws NamingException {
						return (String) attr.get("cn").get();
					}
				});
	}
	
}
