package es.uem.aju.common.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.util.PropertiesLoader;


public class DummyDAOMySQLTest {

	private static Properties properties;
	private static DataSource datasource;
	
	
	@BeforeClass
    public static void setUp() {
		properties = PropertiesLoader.loadProperties("mysql.test.properties");    
    }
	
	
	@Test
	public void permormTests(){
		testMySQLProperties();
		testMYSQLConnection();
		testDummyDAOMySQL();
	}
	
	public void testMySQLProperties(){
		assertTrue( properties != null );
	}
	
	 
	public void testMYSQLConnection(){
		DatasourceMySQLFactory factory = new DatasourceMySQLFactory();
		datasource = factory.createDatasource(properties);
		
		assertTrue(datasource != null);
		try {
			assertTrue(datasource.getConnection() != null);
		} catch (SQLException e) {
			fail(e.getMessage());			
		}
	}	
	
	public void testDummyDAOMySQL(){
		
		DummyDAOMySQL dummyDao = new DummyDAOMySQL(datasource);
		List<DummyDTO> dummies = new ArrayList<DummyDTO>();						
		dummies = dummyDao.findDummies();
		
		assertTrue(dummies.size() == 2);					
		assertTrue(dummies.get(0).getName().equalsIgnoreCase("dummy1"));
		assertTrue(dummies.get(1).getName().equalsIgnoreCase("dummy2"));
	}
	
	
}
