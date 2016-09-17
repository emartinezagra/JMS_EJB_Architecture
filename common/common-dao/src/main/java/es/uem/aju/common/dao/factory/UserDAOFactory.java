package es.uem.aju.common.dao.factory;

import es.uem.aju.common.dao.UserDAOMySQL;

public class UserDAOFactory extends AbstractDAOFactory {

	@Override
	public UserDAOMySQL getDAO(String type) {
		return new UserDAOMySQL(AbstractDAOFactory.getDataSource(DatasourceMySQLFactory.MY_SQL));
	}
}
