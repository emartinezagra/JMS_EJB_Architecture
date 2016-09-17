package es.uem.aju.common.test;

import java.util.Properties;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uem.aju.common.util.PropertiesLoader;


public class PropertiesLoaderTest {
	
	private static Properties properties;	
	
	@BeforeClass
    public static void setUp() {
		properties = PropertiesLoader.loadProperties("test.properties");    
    }
	
	@Test
	public void permormTests(){
		tesPropertiesLoader();
				
	}
	
	public void tesPropertiesLoader(){
		assertTrue( properties != null );
		assertTrue(properties.getProperty("key1").equalsIgnoreCase("value1"));
		assertTrue(properties.getProperty("key2").equalsIgnoreCase("value2"));
	}	 	
}
