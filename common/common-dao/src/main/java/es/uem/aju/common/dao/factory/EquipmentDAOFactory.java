package es.uem.aju.common.dao.factory;

import es.uem.aju.common.dao.EquipmentDAOMySQL;

public class EquipmentDAOFactory extends AbstractDAOFactory {

	@Override
	public EquipmentDAOMySQL getDAO(String type) {
		return new EquipmentDAOMySQL(AbstractDAOFactory.getDataSource(DatasourceMySQLFactory.MY_SQL));
	}
}
