package ene.blue.spring.mongo;

import java.io.Serializable;

public interface UpsertAction<T> {
	
	public void upsertById(Serializable id, T o);
	
}
