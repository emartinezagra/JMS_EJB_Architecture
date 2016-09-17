package es.uem.aju.common.dao.factory;

import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import es.uem.aju.common.dao.interfaces.DataSourceFactory;

public class DatasourceMySQLFactory implements DataSourceFactory {
	
	public static final String MY_SQL = "mysql";
	public static final String MYSQL_PROPERTIES = "mysql.properties";
	
	public DataSource createDatasource(Properties properties){				
       MysqlDataSource dataSource = new MysqlDataSource();
       dataSource.setUrl(properties.getProperty("connection-url"));
       dataSource.setUser(properties.getProperty("username"));
       dataSource.setPassword(properties.getProperty("password"));       
       return dataSource;
	}
}