package ene.blue.spring.mongo.bean;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Controller;

import com.mongodb.MongoClient;

@Controller
public class MongoConfig {
	/**
	 * 创建连接MongoDB的连接资源
	 * @return
	 * @throws UnknownHostException
	 */
	public @Bean MongoClient mongoClient() throws UnknownHostException{
		return new MongoClient("localhost");
	}
	
	/**
	 * 使用连接资源创建连接MongoDB中一个数据库实例的模板
	 * @return
	 * @throws UnknownHostException
	 */
	public @Bean MongoTemplate mongoTemplate() throws UnknownHostException{
		//return new MongoTemplate(mongoClient(), "springDB");
		return new MongoTemplate(mongoDbFactory());
	}
	
	
	public @Bean MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(mongoClient() , "springDB");
	}
}
