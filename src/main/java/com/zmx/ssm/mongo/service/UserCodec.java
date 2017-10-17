package com.zmx.ssm.mongo.service;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import com.zmx.ssm.user.domain.User;

public class UserCodec implements Codec<User>{


	@Override
	public User decode(BsonReader reader, DecoderContext decoderContext) {
		        User user = new User();  
		        reader.readStartDocument();  
		        //_id是插入数据时自动生成的项  
		        reader.readObjectId("_id");
		        user.setId(reader.readInt32("id")); 
		        user.setAccount(reader.readString("account"));  
		        user.setPassword(reader.readString("password"));           
	            reader.readEndDocument();  
		        return user;

	}

	
	@Override
	public void encode(BsonWriter writer, User value, EncoderContext encoderContext) {
		        writer.writeStartDocument(); 
		        writer.writeInt32("id", value.getId());
		        writer.writeString("account", value.getAccount());  
		        writer.writeString("password", value.getPassword());  		      
		        writer.writeEndDocument();  
		
	}

	@Override
	public Class<User> getEncoderClass() {
		
		 return User.class; 
	}



}
