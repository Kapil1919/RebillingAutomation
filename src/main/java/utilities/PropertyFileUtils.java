package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtils {
	
	//Method to call static values from environment properties file. 
	public static String getValueForKey(String Key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/Project_Rebilling/PropertiesFile/Environment.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		
		
		return prop.getProperty(getValueForKey(Key));
		
	}

}


/*
 * public class PropertyFileUtil { 
 * 
 * public static String getValueForKey(String
 * Key) throws Exception{
 * 
 * FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+
 * "/PropertiesFile/Environment.properties");
 * 
 * Properties configProperties=new Properties();
 * 
 * configProperties.load(fis);
 * 
 * return configProperties.getProperty(Key); }
 * 
 * }
 */
