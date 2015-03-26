package com.mhuang.common.frame.factorybean;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

/**
 * mongoFacotry
 * @author huangmiao
 */
public class MongoFacotry extends MongoCRUDFacotry{

	private MongoDataSource mongoDataSource;
	/**
	 * get mongoCollection the operation table
	 * source MongoCollection operation
	 * @return
	 */
	public MongoCollection<Document> getDBCollection(String collectionName){
		return this.mongoDataSource.mongoDatabase.getCollection(collectionName);
	}
	
	
	/********************set get*************************/
	
	public MongoDataSource getMongoDataSource() {
		return mongoDataSource;
	}
	public void setMongoDataSource(MongoDataSource mongoDataSource) {
		this.mongoDataSource = mongoDataSource;
	}

	
}
