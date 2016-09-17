package es.uem.aju.rp.business;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import es.uem.aju.common.dao.LocationDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dao.factory.LocationDAOFactory;
import es.uem.aju.common.dto.LocationDTO;
import es.uem.aju.common.dto.LocationListDTO;

@Stateless( name = "LocationService" )
@Local( LocationServiceLocal.class )
@Remote( LocationServiceRemote.class )
public class LocationService implements LocationServiceLocal {

	private LocationDAOMySQL locationDAO;
	
	@PostConstruct
	public void postConstruct(){
		LocationDAOFactory daoFactory = new LocationDAOFactory();
		locationDAO = daoFactory.getDAO(DatasourceMySQLFactory.MY_SQL);
	}
	
	public LocationDTO find(Integer pk) {
		return locationDAO.find(pk);
	}

	public LocationListDTO findAll() {
		return locationDAO.findAll();
	}
}
