package com.GenricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains only property file specific common methods
 * @author CHANDAN KUMARa
 *
 */

public class PropertyFileUtility {
	 Properties property;
	/**
	 * This method used to open the property file
	 * @param filePath
	 * @throws IOException
	 */
	
	public  void openPropertyFile(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
         property = new Properties();
		property.load(fis);
	}
	/**
	 * This method use to fetch the data from the property file
	 * @param key
	 * @return
	 */
	public String getDataFromPropertFile(String key) {
		String value = property.getProperty(key);
		return value;
	}
	
	
	

}
