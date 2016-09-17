package es.uem.aju.common.dao.factory;

import es.uem.aju.common.dao.LocationDAOMySQL;

public class LocationDAOFactory extends AbstractDAOFactory {

	@Override
	public LocationDAOMySQL getDAO(String type) {
		return new LocationDAOMySQL(AbstractDAOFactory.getDataSource(DatasourceMySQLFactory.MY_SQL));
	}
}