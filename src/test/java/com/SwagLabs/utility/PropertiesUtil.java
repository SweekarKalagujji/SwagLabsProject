package com.SwagLabs.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	public Properties p1;
	public PropertiesUtil()
	{
		
	
	p1= new Properties();
	File f1= new File("./" + "\\config.properties");
	FileInputStream f2;
	try {
	 f2= new FileInputStream(f1);
	p1.load(f2);
	}catch(Exception e)
	{
		
	}}
	
	public String getData(String key) {
		return p1.getProperty(key);
	}
	

}
	
	
	


