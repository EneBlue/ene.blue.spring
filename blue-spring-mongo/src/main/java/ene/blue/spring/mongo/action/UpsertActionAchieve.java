package ene.blue.spring.mongo.action;

import java.io.Serializable;

import ene.blue.spring.mongo.UpsertAction;

public class UpsertActionAchieve<T> 
	extends BaseActionAchieve<T> implements UpsertAction<T> {

	@Override
	public void upsertById(Serializable id, T o) {
		/*template.upsert(query(where("firstName").is("Ene").and("secondName").is("Blue").and("age").is(101)), 
				update("address", "Kong of stree"), Person.class);
		
		
		mongoTemplate.upsert(query(where("id").is(id)), update("address", "Kong of stree").update(key, value), o.getClass());
		*/
	}
	
}
