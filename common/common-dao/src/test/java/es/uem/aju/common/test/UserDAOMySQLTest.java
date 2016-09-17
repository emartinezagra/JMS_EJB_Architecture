package es.uem.aju.common.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uem.aju.common.dao.LocationDAOMySQL;
import es.uem.aju.common.dao.UserDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.LocationDTO;
import es.uem.aju.common.dto.UserDTO;
import es.uem.aju.common.util.PropertiesLoader;

public class UserDAOMySQLTest {

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
		UserDAOMySQL dao = new UserDAOMySQL(datasource);	
		UserDTO user = dao.find(0);				
		
		//(0,"Lou Crowner","loucrowner@bankofscotland.com","91 - 626 - 351 - 672",0);
		
		assertTrue(user != null);
		assertTrue(user.getId() == 0);
		assertTrue(user.getName().equals("Lou Crowner"));
		assertTrue(user.getEmail().equals("loucrowner@bankofscotland.com"));
		assertTrue(user.getPhone().equals("91 - 626 - 351 - 672"));
		assertTrue(user.getCompanyId() == 0);	
	}	
}
