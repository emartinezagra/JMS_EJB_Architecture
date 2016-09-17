package es.uem.aju.common.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class BaseDAO {
	
	protected DataSource datasource;
	
	protected static Logger log = Logger.getLogger( BaseDAO.class );
	
	public BaseDAO(DataSource datasource){
		this.datasource = datasource;
	}
}
