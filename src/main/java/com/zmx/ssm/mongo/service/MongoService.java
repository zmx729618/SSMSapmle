package com.zmx.ssm.mongo.service;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.zmx.ssm.user.domain.User;

/**
 * 
 * @author zhangwenchao
 *
 */
public class MongoService {
	
	private static MongoClientOptions options;
	
	static{
	    MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		//与数据最大连接数50
		build.connectionsPerHost(50);
		//如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
		build.threadsAllowedToBlockForConnectionMultiplier(50);
		build.connectTimeout(1*60*1000);
		build.maxWaitTime(2*60*1000);
		options = build.build();	
	}
	
	public void insertOneDocument(){
		
		MongoClient client = new MongoClient("127.0.0.1", options);
	    //获取数据库test,不存在的话，会自动建立该数据库
		MongoDatabase db = client.getDatabase("test");
		
	    //获取data集合，不存在的话，会自动建立该集合（相当于关系数据库中的数据表）
	    MongoCollection<Document> users = db.getCollection("data");
		Document document = new Document();
		document.append("firstName", "lei");
		document.append("address", "sichuan chengdu");
		users.insertOne(document);
		//MongoClient使用完后必须要close释放资源
		client.close();
		
	}
	
	
	public void insertOneDomain(){
		
		MongoClient client = new MongoClient("127.0.0.1", options);
	    //获取数据库test,不存在的话，会自动建立该数据库
		MongoDatabase db = client.getDatabase("test");
		
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(new UserCodec()),MongoClient.getDefaultCodecRegistry());  
		
	    //获取data集合，不存在的话，会自动建立该集合（相当于关系数据库中的数据表）
		MongoCollection<User> users = db.getCollection("user",User.class).withCodecRegistry(codecRegistry); 
	    User u = new User();  
	    u.setId(12);  
	    u.setAccount("Green");
	    u.setPassword("123456");
	   
	    users.insertOne(u); 
	    //MongoClient使用完后必须要close释放资源
		client.close();
		
	}
	
	
	public void findOneDomain(){
		
		MongoClient client = new MongoClient("127.0.0.1", options);
	    //获取数据库test,不存在的话，会自动建立该数据库
		MongoDatabase db = client.getDatabase("test");
		
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(new UserCodec()),MongoClient.getDefaultCodecRegistry());  
		
	    //获取data集合，不存在的话，会自动建立该集合（相当于关系数据库中的数据表）
		MongoCollection<User> users = db.getCollection("user",User.class).withCodecRegistry(codecRegistry); 
		User u = users.find().first();  
		System.out.println(u.getId()+">>>"+u.getAccount()+">>>"+u.getPassword());  
		//MongoClient使用完后必须要close释放资源  
		client.close(); 

		
	}
	
	
     public static void main(String[] args) {
    	 
    	 MongoService mongoService = new  MongoService();
    	 
    	// mongoService.insertOneDocument();
    	// mongoService.insertOneDomain();
    	   mongoService.findOneDomain();
	}
}
