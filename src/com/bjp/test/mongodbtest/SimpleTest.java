package com.bjp.test.mongodbtest;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

public class SimpleTest {

	private static MongoClient mongoClient;

	public static void main(String[] args) throws UnknownHostException, MongoException {
		try {  
		    String sURI = String.format("mongodb://%s:%s@%s:%d/%s", "alfieri", "selphina", "120.78.173.202", 27017, "xupu"); 
		    MongoClientURI uri = new MongoClientURI(sURI); 
		    mongoClient = new MongoClient(uri); 
		    MongoDatabase  myDB  = mongoClient.getDatabase("xupu");
		    
		    /** 插入文档 */  
            // 创建文档 org.bson.Document对象，参数为K:V格式
            // 创建文档集合List<Document> 
            // 将文档集合插入数据库集合中collection.insertMany(List<Document>)，插入单个文档可以用collection.insertOne(Document)
//		    myDB.createCollection("genealogymember");
		    MongoCollection<Document> myCollection= myDB.getCollection("genealogymember");
            List<Document> docList = new ArrayList<Document>();
            for (int idx = 0; idx < 10; ++idx) {
            	Document sub1 = new Document("haha1", "asd1" ).
            			append("desc", "数据库1" );
            	Document sub2 = new Document("haha2", "asd2" ).
            			append("desc", "数据库2" );
            	Document sub = new Document("sub1", sub1).
                        append("sub2", sub2);
                Document doc = new Document("title", "MongoDB" + idx).
                        append("desc", "数据库" + idx).
                        append("likes", 100 + idx * 10).
                        append("by", "dsp" + idx).append("sub", sub);
                docList.add(doc);
            }
            myCollection.insertMany(docList);
            
//            FindIterable<Document> findIterable = myCollection.find();
//            MongoCursor<Document> mongoCursor = findIterable.iterator();
//            try {
//            	while (mongoCursor.hasNext()) {
//            		System.out.println(mongoCursor.next().toJson());
//            	}
//            } finally {
//            	mongoCursor.close();
//            }
//		    MongoCollection<Document> myCollection= myDB.getCollection("puwens");
//            FindIterable<Document> findIterable = myCollection.find();
//            MongoCursor<Document> mongoCursor = findIterable.iterator();
//            try {
//                while (mongoCursor.hasNext()) {
//                    System.out.println(mongoCursor.next().toJson());
//                }
//            } finally {
//                mongoCursor.close();
//            }
             
            /** 删除文档 */
//    		MongoCollection<Document> myCollection= myDB.getCollection("genealogymember");
//            DeleteResult deleteResult = myCollection.deleteMany(Filters.eq("likes", 30));
//            System.out.println("本次删除 " + deleteResult.getDeletedCount() + " 条记录！");  
		   
		    } catch (MongoException e) {  
		    	e.printStackTrace();  
		    }  
		
		
		
         
        
          
//        DB db = mg.getDB("test");  
//        //查询所有的聚集集合  
//        for (String name : db.getCollectionNames()) {  
//            System.out.println("collectionName: " + name);  
//        }  
//          
//        DBCollection users = db.getCollection("users");  
//          
//        //查询所有的数据  
//        DBCursor cur = users.find();  
//        while (cur.hasNext()) {  
//            System.out.println(cur.next());  
//        }  
//        System.out.println(cur.count());  
//        System.out.println(cur.getCursorId());  
//        System.out.println(JSON.serialize(cur));  

	}

}
