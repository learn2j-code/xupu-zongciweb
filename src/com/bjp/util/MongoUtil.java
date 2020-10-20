package com.bjp.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoUtil {
	private static MongoClient mongoClient;
	private static MongoDatabase mongoDatabase;

	public MongoUtil(String dbName) {
		// TODO Auto-generated constructor stub
		ServerAddress serverAddress = new ServerAddress("120.78.173.202", 27017);
		List<ServerAddress> addrs = new ArrayList<ServerAddress>();
		addrs.add(serverAddress);
		// 下面这句，是哪个库的用户，必须在其下面认证才行，我这个用户admin是root最高权限，所以在要admin下认证，这个地方折腾了好久：（
		MongoCredential credential = MongoCredential.createScramSha1Credential("admin", "admin", "selphina".toCharArray());
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(credential);

		mongoClient = new MongoClient(addrs, credentials);
		mongoDatabase = mongoClient.getDatabase(dbName);
	}

	/**
	 * 创建一个数据库集合
	 * 
	 * @param collName
	 *            集合名称
	 * @param db
	 *            数据库实例
	 */
	public void createCollection(String collName) {
		// 先查看集合是否存在
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		if(collection==null){
			mongoDatabase.createCollection(collName);
		}
	}

	/**
	 * 为相应的集合添加一条或多条数据
	 * 
	 * @param dbs
	 * @param collName
	 */
	public void insert(List<Document> dbs, String collName) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		// 2.插入操作
		collection.insertMany(dbs);
	}

	/**
	 * 检索某集合中所有的记录
	 * 
	 * @param collName
	 * @return MongoCursor<Document>
	 */
	public MongoCursor<Document> findAll(String collName) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while (mongoCursor.hasNext()) {
			System.out.println(mongoCursor.next());
		}
		return mongoCursor;
	}

	/**
	 * 修改某集合中的记录
	 * 
	 * @param collName
	 * @param whereName
	 * @param where
	 * @return MongoCursor<Document>
	 */
	public void updata(String collName, String whereName, String where, Document dbs) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		collection.updateMany(Filters.eq(whereName, where), new Document("$set", dbs));
	}

	/**
	 * 删除某集合中的第一条符合条件的记录
	 * 
	 * @param collName
	 * @param whereName
	 * @param where
	 */
	public void delete(String collName, String whereName, String where) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		collection.deleteOne(Filters.eq(whereName, where));
	}

	/**
	 * 删除某集合中的全部符合条件的记录
	 * 
	 * @param collName
	 * @param whereName
	 * @param where
	 */
	public void deleteAll(String collName, String whereName, String where) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		collection.deleteMany(Filters.eq(whereName, where));
	}
	
	/**
	 * 删除某集合中的全部符合条件的记录
	 * @param collName
	 * @param whereName1
	 * @param where1
	 * @param whereName2
	 * @param where2
	 */
	public void deleteAllByTwoConditions(String collName, String whereName1, String where1, String whereName2, String where2) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		collection.deleteMany(Filters.and(Filters.eq(whereName1, where1),Filters.eq(whereName2, where2)));
	}
	
	public void closeConnection(){
		mongoClient.close();
	}

	public static void main(String[] args) {
		String databaseName = "xupu";
		String collectionName = "genealogymember";
		MongoUtil mongoDb = new MongoUtil(databaseName);
		// 创建一个数据库集合
		mongoDb.createCollection(collectionName);
		// 为相应的集合添加一条或多条数据
		Document document = new Document("name", "uuuuu");
		List<Document> documents = new ArrayList<Document>();
		documents.add(document);
		mongoDb.insert(documents, collectionName);

		// 检索某集合中所有的记录
//		mongoDb.findAll("genealogymember");
		// 修改某集合中的记录
//		Document document = new Document("name", "uuuuu");
//		mongoDb.updata("aaa", "name", "aaaa", document);
		// 删除某集合中的第一条符合条件的记录
		// mongoDb.delete("aaa","name","uuuuu");
		// 删除某集合中的全部符合条件的记录
		// mongoDb.deleteAll("aaa","name","uuuuu");

		// 关闭数据库连接
		mongoDb.closeConnection();
	}
}
