package es.uem.aju.common.dao.factory;

import es.uem.aju.common.dao.CompanyDAOMySQL;

public class CompanyDAOFactory extends AbstractDAOFactory {

	@Override
	public CompanyDAOMySQL getDAO(String type) {
		return new CompanyDAOMySQL(AbstractDAOFactory.getDataSource(DatasourceMySQLFactory.MY_SQL));
	}	
}