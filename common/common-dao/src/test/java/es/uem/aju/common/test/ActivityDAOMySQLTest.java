package es.uem.aju.common.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uem.aju.common.dao.ActivityDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.ActivityDTO;
import es.uem.aju.common.util.PropertiesLoader;

public class ActivityDAOMySQLTest {
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
		testStore();
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
	private void testStore(){
		ActivityDAOMySQL dao = new ActivityDAOMySQL(datasource);	
		ActivityDTO activity = new ActivityDTO(0, 1, 1, null, true);
		try {
			dao.store(activity);
		} catch (SQLException e) {
			fail(e.getMessage());			
		}
		assertTrue(activity != null);
	}
}
