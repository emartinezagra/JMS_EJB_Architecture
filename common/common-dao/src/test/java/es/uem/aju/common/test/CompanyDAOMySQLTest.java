package es.uem.aju.common.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uem.aju.common.dao.CompanyDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.CompanyDTO;
import es.uem.aju.common.util.PropertiesLoader;

public class CompanyDAOMySQLTest {

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
		testFindCompanyByName();
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
		CompanyDAOMySQL dao = new CompanyDAOMySQL(datasource);	
		CompanyDTO company = dao.find(0);
		
		assertTrue(company != null);
		assertTrue(company.getName().equals("Bank of Scotland"));
		assertTrue(company.getLocationId() == 1);
	}
	
	private void testFindCompanyByName(){
		CompanyDAOMySQL dao = new CompanyDAOMySQL(datasource);		
		CompanyDTO company = dao.findCompanyByName("Bank of Scotland");
		
		assertTrue(company != null);
		assertTrue(company.getName().equals("Bank of Scotland"));
		assertTrue(company.getLocationId() == 1);		
	}
}
