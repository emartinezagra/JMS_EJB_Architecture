package es.uem.aju.common.dao.interfaces;

import java.util.Properties;

import javax.sql.DataSource;

public interface DataSourceFactory {

	public DataSource createDatasource(Properties properties);
	
}
