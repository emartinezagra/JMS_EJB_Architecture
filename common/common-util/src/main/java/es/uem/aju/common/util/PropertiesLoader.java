package es.uem.aju.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author emartinezagra
 *
 */
public class PropertiesLoader {
	
	private static Logger log = Logger.getLogger( PropertiesLoader.class );
	
	public static Properties loadProperties(String file){	
					
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = PropertiesLoader.class.getClassLoader().getResourceAsStream(file);									
			properties.load(input);				
		} catch (IOException ex) {
			log.error("Error loading properties: "+file +ex.getMessage());
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					log.error("Error closing input stream: "+file +e.getMessage());
				}
			}
		}
		return properties;				
	}
}