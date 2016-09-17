package es.uem.aju.common.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uem.aju.common.dao.LocationDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.LocationDTO;
import es.uem.aju.common.util.PropertiesLoader;

public class LocationDAOMysqlTest {

	private static Properties properties;
	private static DataSource datasource;
	
	
	@BeforeClass
    public static void setUp() {
		properties = PropertiesLoader.loadProperties("mysql.properties");    
    }
	
	@Test
	public void permormTests(){
		testMySQLProperties();
		testMYSQLConnection();
		testFind();		
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
	
	private void testFind(){
		LocationDAOMySQL dao = new LocationDAOMySQL(datasource);	
		LocationDTO location = dao.find(0);				
		
		assertTrue(location != null);
		assertTrue(location.getId() == 0);
		assertTrue(location.getCoordinateX()==12);
		assertTrue(location.getCoordinateY()==45);
		assertTrue(location.getLocationId()==0);
		assertTrue(location.getName().equals("Finance Trading Complex"));	
	}	
}
