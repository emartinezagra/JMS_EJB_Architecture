package es.uem.aju.common.dao.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import es.uem.aju.common.dao.base.GenericDAO;
import es.uem.aju.common.util.PropertiesLoader;

public abstract class AbstractDAOFactory {
	
	public static Map<String, DataSource> loadedDatasource = new HashMap<String, DataSource>();
	
	public static DataSource getDataSource(String type){

		if (AbstractDAOFactory.loadedDatasource.get(type) == null){
		
			if (type.equalsIgnoreCase(DatasourceMySQLFactory.MY_SQL)){
				 Properties properties = PropertiesLoader.loadProperties(DatasourceMySQLFactory.MYSQL_PROPERTIES);
				 DatasourceMySQLFactory mySQLfactory = new DatasourceMySQLFactory();
				 DataSource mysqlDataSource = mySQLfactory.createDatasource(properties);
				 AbstractDAOFactory.loadedDatasource.put(DatasourceMySQLFactory.MY_SQL, mysqlDataSource);
				 return mysqlDataSource;
			 }else{
				 return null;
			 }
		}else{
			return AbstractDAOFactory.loadedDatasource.get(type);
		}				
	}
	
	public abstract GenericDAO getDAO(String type);

}