package com.report.logic;

/**
 * for load config 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ModuleConfig {
	
	private static Properties appConfig;
	
	static public Properties getinstance()
	{
		if(appConfig == null)
			loadconfig();
		
		return appConfig;
	}
	
	static public void loadconfig()
	{
		appConfig = new Properties();
		Properties newConfig = new Properties();
		File configFile = new File("report.properties");
		try {
			newConfig.load(new BufferedReader(new FileReader(configFile)));
			appConfig = newConfig;
			
		} catch (FileNotFoundException e) {
			try {
				newConfig.load(ModuleConfig.class.getClassLoader().getResourceAsStream("/report.properties"));
				appConfig = newConfig;
			
			} catch (IOException e1) {
			
				System.exit(-1);
			}
		} catch (IOException e) {
			System.exit(-1);
		}
	}
	

}
