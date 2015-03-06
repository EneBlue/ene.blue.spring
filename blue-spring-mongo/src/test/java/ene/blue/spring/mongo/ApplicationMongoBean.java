package ene.blue.spring.mongo;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ene.blue.spring.mongo.jopo.Person;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext-mongo-bean.xml"})
public class ApplicationMongoBean {
	
	private static final Log log = LogFactory.getLog(ApplicationMongoBean.class);
	
	@Resource
	private BaseAction<Person> baseAction;
	
	@Test
	public void test(){
		Person person = new Person();
		person.setName("XXXXXX");
		person.setAge(30);
		baseAction.save(person);
		log.info(person.getId());// 2015-02-06 14:21:23,339 INFO   - 54d45d634032606b8f7255fb
		
		baseAction.dropCollection(Person.class);
	}
}
