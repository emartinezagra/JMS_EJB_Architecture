package es.uem.aju.common.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uem.aju.common.dao.EquipmentDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.EquipmentDTO;
import es.uem.aju.common.util.PropertiesLoader;

public class EquipmentDAOMySQLTest {

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
		EquipmentDAOMySQL dao = new EquipmentDAOMySQL(datasource);	
		EquipmentDTO equipment = dao.find(0);
		
		assertTrue(equipment != null);
		assertTrue(equipment.getId() == 0);
		assertTrue((equipment.getStatus() != null && equipment.getStatus().length()>0));
		assertTrue(equipment.getLocationID() == 4);	
	}	
}
