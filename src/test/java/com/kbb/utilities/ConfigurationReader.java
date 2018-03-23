package com.kbb.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	private static Properties properties;
	static{
		try {
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream("./configuration.properties");
			properties.load(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}
}
