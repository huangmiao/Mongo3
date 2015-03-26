package com.mhuang.common.frame.factorybean;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

/**
 * @author huangmiao
 */
public interface MongoCrudFactory {

	MongoCollection<Document> getDBCollection(String collectionName);
	
	
}
