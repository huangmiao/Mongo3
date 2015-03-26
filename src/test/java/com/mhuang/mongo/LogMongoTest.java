package com.mhuang.mongo;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * mongo connection test 
 * @mongo-version:3.0 RC
 * @author huangmiao
 *
 */
public class LogMongoTest {
	
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		mongoClient.setWriteConcern(WriteConcern.JOURNALED);
		MongoDatabase mongoDataBase = mongoClient.getDatabase("test");
//		mongoDataBase.createCollection("testCollection");
		MongoCollection<Document> mongoCollection = mongoDataBase.getCollection("testCollection1222");
		System.out.println(mongoCollection);
		/**
		 * query of insert
		 */
//		BasicDBObject doc = new BasicDBObject("name", "MongoDB")
//        .append("type", "database")
//        .append("count", 1)
//        .append("info", new BasicDBObject("x", 203).append("y", 102));
//		BasicDBObject doc2 = new BasicDBObject("$set",new BasicDBObject("type", "database111"));
//		mongoCollection.insertOne(new Document(doc.toMap()));
//		Document document = (Document) mongoCollection.find().first();
//		System.out.println(document);
//		/**
//		 * update
//		 */
//		UpdateResult updateResult = mongoCollection.updateOne(doc, doc2);
//		System.out.println("update");
//		System.out.println(updateResult.getUpsertedId());
//		System.out.println( mongoCollection.find().first());
//		/**
//		 * delete
//		 */
//		DeleteResult result = mongoCollection.deleteOne(doc);
//		System.out.println("delete");
//		System.out.println(result.getDeletedCount());
//		System.out.println(mongoCollection.count());
//		mongoCollection.find().forEach(new Block<Document>() {
//			@Override
//			public void apply(Document t) {
//				System.out.println(t);
//				System.out.println(t.getObjectId("_id"));
//			}
//			}
//		);
//		/**
//		 * find 参数查询
//		 */
//		mongoCollection.find(new BasicDBObject("type",new BasicDBObject("$eq","database111"))).forEach(new Block<Document>() {
//			@Override
//			public void apply(Document t) {
//				System.out.println("====");
//				System.out.println(t);
//			}
//		});
//		mongoClient.close();
	}
}
