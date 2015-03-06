package ene.blue.spring.ldap;

import org.springframework.ldap.repository.LdapRepository;
import org.springframework.ldap.repository.Query;

public interface PersonRepository extends LdapRepository<Person>{

	@Query("(sn={0})")
	Iterable<Person> findByLastName(String lastName);
	
	@Query("(uid={0})")
	Person findByUid(String uid);
	
	Person findByTelephoneNumber(String phoneNumber);
}
