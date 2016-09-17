package es.uem.aju.common.dao.factory;

import es.uem.aju.common.dao.ActivityDAOMySQL;

public class ActivityDAOFactory extends AbstractDAOFactory {

	@Override
	public ActivityDAOMySQL getDAO(String type) {
		return new ActivityDAOMySQL(AbstractDAOFactory.getDataSource(DatasourceMySQLFactory.MY_SQL));
	}

}
