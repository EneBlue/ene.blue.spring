package ene.blue.spring.mongo;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ene.blue.spring.mongo.jopo.Person;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext-mongo.xml"})
public class ApplicationMongoXML extends AbstractJUnit4SpringContextTests{
	
	/**
	 * 本类为使用以用XML的方式配置MongoDB数据库
	 * 并调用数据库接口的方式
	 */
	
	private static final Log log = LogFactory.getLog(ApplicationMongoXML.class);
	
	@Resource
	private BaseAction<Person> baseAction;
	
	@Test
	public void test(){
		Person person = new Person();
		person.setName("XXXXXX");
		person.setAge(30);
		baseAction.save(person);
		log.info(person.getId());// 2015-02-06 14:22:41,892 INFO   - 54d45db14032910b28ba6ffc
		
		baseAction.dropCollection(Person.class);
	}
	
}
