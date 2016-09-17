package es.uem.aju.rp.business;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import es.uem.aju.common.dao.ActivityDAOMySQL;
import es.uem.aju.common.dao.factory.ActivityDAOFactory;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.ActivityDTO;
import es.uem.aju.common.dto.ActivityListDTO;

@Stateless( name = "ActivityService" )
@Local( ActivityServiceLocal.class )
@Remote( ActivityServiceRemote.class )
public class ActivityService implements ActivityServiceLocal{

	private ActivityDAOMySQL actyivityDao;
	
	@PostConstruct
	public void postConstruct(){
		ActivityDAOFactory daoFactory = new ActivityDAOFactory();
		actyivityDao = daoFactory.getDAO(DatasourceMySQLFactory.MY_SQL);
	}
	
	public ActivityDTO find(Integer pk) {
		return actyivityDao.find(pk);
	}

	public ActivityListDTO findAll() {
		return actyivityDao.findAll();
	}
}
