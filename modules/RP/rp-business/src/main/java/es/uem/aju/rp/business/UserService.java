package es.uem.aju.rp.business;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import es.uem.aju.common.dao.UserDAOMySQL;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dao.factory.UserDAOFactory;
import es.uem.aju.common.dto.UserDTO;
import es.uem.aju.common.dto.UserListDTO;

@Stateless( name = "UserService" )
@Local( UserServiceLocal.class )
@Remote( UserServiceRemote.class )
public class UserService implements UserServiceLocal {

	private UserDAOMySQL userDAO;
	
	@PostConstruct
	public void postConstruct(){
		UserDAOFactory daoFactory = new UserDAOFactory();
		userDAO = daoFactory.getDAO(DatasourceMySQLFactory.MY_SQL);
	}
	
	public UserDTO find(Integer pk) {
		return userDAO.find(pk);
	}

	public UserListDTO findAll() {
		return userDAO.findAll();
	}
}
