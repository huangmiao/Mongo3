package com.mhuang.common.frame.factorybean.config;

/**
 * mongo base settings
 * @author huangmiao
 */
public interface MongoSettings {

	/**default mongo settings*/
	public final static String DEFAULT_MONGO_HOST = "localhost";
	public final static int DEFAULT_MONGO_PORT = 27017;
	/**mongo settings query parameter*/
	public final static String PARAMETER_SET = "$set";
	public final static String PARAMETER_EQ = "$eq"; 
}
