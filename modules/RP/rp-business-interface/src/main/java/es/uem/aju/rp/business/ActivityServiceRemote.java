package es.uem.aju.rp.business;

import es.uem.aju.common.dto.ActivityDTO;
import es.uem.aju.common.dto.ActivityListDTO;

public interface ActivityServiceRemote {

	public ActivityDTO find(Integer pk);
	
	public ActivityListDTO findAll();
}
