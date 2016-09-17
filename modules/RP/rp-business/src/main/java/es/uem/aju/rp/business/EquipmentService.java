package es.uem.aju.rp.business;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import es.uem.aju.common.dao.EquipmentDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dao.factory.EquipmentDAOFactory;
import es.uem.aju.common.dto.EquipmentDTO;
import es.uem.aju.common.dto.EquipmentListDTO;

@Stateless( name = "EquipmentService" )
@Local( EquipmentServiceLocal.class )
@Remote( EquipmentServiceRemote.class )
public class EquipmentService implements EquipmentServiceLocal {

private EquipmentDAOMySQL equipmentDAO;
	
	@PostConstruct
	public void postConstruct(){
		EquipmentDAOFactory  daoFactory = new EquipmentDAOFactory();
		equipmentDAO = daoFactory.getDAO(DatasourceMySQLFactory.MY_SQL);
	}
	
	public EquipmentDTO find(Integer pk) {
		return equipmentDAO.find(pk);
	}

	public EquipmentListDTO findAll() {
		return equipmentDAO.findAll();
	}
}
