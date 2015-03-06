package ene.blue.spring.mongo;

import java.util.List;

public interface BaseAction<T> {
	
	public void save(T o);
	public void save(T o, String collectionName);
	
	public void insert(T o);
	public void insert(T o, String collectionName);
	
	public void remove(T o);
	public void remove(T o, String collectionName);
	
	public List<T> findAll(Class<T> classObj);
	public List<T> findAll(Class<T> classObj, String collectionName);
	
	public void dropCollection(Class<T> classObj);
	public void dropCollection(String collectionName);
	
	/*

	public void addToSet(String key, T o);
	public void inc(String key, Number inc);
	public void pop(String key, Position position);
	public void pull(String key, T o);
	public void pullAll(String key, T[] os);
	public void push(String key, T o);
	public void pushAll(String key, T[] os);
	public void rename(String oldName, String newName);
	public void set(String key, T o);
	public void unset(String key);
	
	*/
	
	
	
}
