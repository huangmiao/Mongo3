package com.mhuang.common.frame.factorybean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mhuang.common.frame.factorybean.config.MongoSettings;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 * mongo datastore
 * @author huangmiao
 *
 */
public class MongoDataSource implements MongoSettings,Serializable{

	private static final long serialVersionUID = 1L;

	protected volatile String database;

	protected volatile boolean isBase = true; 
	
	protected volatile String host;
	
	protected volatile int port; 
	
	protected volatile String userName;
	
	protected volatile String password;
	
	private MongoClient mongoClient;
	
	protected MongoDatabase mongoDatabase;
	
	protected volatile ServerAddress[] serverAddresses = new ServerAddress[]{};
	
	public MongoDataSource(){
		super();
	}
	public void init(){
		if(!isBase){
			if(StringUtils.isBlank(host))
				host = DEFAULT_MONGO_HOST;
			if(port == 0)
				port = DEFAULT_MONGO_PORT;
			mongoClient = new MongoClient(host,port);
		}else{
			 List<ServerAddress> serverAddressList = Arrays.asList(serverAddresses);
			 mongoClient = new MongoClient(serverAddressList);
		}
		mongoDatabase = mongoClient.getDatabase(database);
	}
	
	public ServerAddress[] getServerAddresses() {
		return serverAddresses;
	}
	public void setServerAddresses(ServerAddress[] serverAddresses) {
		this.serverAddresses = serverAddresses;
	}
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = StringUtils.isNotBlank(host)?host:DEFAULT_MONGO_HOST;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port == 0 ? port:DEFAULT_MONGO_PORT;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isBase() {
		return isBase;
	}
	
	/**
	 * 传入验证类型,false为单个。true为多个
	 * 若为true必须指定他的ServerAddress
	 * @param isBase
	 */
	public void setBase(boolean isBase) {
		this.isBase = isBase;
	}
}
