package es.uem.aju.rp.business;

import es.uem.aju.common.dto.UserDTO;
import es.uem.aju.common.dto.UserListDTO;

public interface UserServiceRemote {
	
	public UserDTO find(Integer pk);

	public UserListDTO findAll();
}
