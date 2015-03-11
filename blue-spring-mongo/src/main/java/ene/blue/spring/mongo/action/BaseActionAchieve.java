package ene.blue.spring.mongo.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ene.blue.spring.mongo.BaseAction;

@Repository("baseAction")
public class BaseActionAchieve<T> implements BaseAction<T>{
	
	@Autowired
	public MongoTemplate mongoTemplate;
	
	@Override
	public void save(T o){
		mongoTemplate.save(o);
	}
	
	@Override
	public void save(T o, String collectionName) {
		mongoTemplate.save(o, collectionName);
	}
	
	@Override
	public void insert(T o){
		mongoTemplate.insert(o);
	}

	@Override
	public void insert(T o, String collectionName) {
		mongoTemplate.insert(o, collectionName);
	}

	@Override
	public List<T> findAll(Class<T> classObj) {
		return mongoTemplate.findAll(classObj);
	}
	
	@Override
	public void remove(T o){
		mongoTemplate.remove(o);
	}
	
	@Override
	public void remove(T o, String collectionName){
		mongoTemplate.remove(o, collectionName);
	}
	
	@Override
	public List<T> findAll(Class<T> classObj, String collectionName) {
		return mongoTemplate.findAll(classObj, collectionName);
	}
	
	@Override
	public void dropCollection(Class<T> classObj) {
		mongoTemplate.dropCollection(classObj);
	}
	
	@Override
	public void dropCollection(String collectionName){
		mongoTemplate.dropCollection(collectionName);
	}

}
