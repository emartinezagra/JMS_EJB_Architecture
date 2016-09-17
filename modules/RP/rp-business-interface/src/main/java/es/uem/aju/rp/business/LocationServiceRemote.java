package es.uem.aju.rp.business;

import es.uem.aju.common.dto.LocationDTO;
import es.uem.aju.common.dto.LocationListDTO;

public interface LocationServiceRemote {
	
	public LocationDTO find(Integer pk);
	
	public LocationListDTO findAll();
}
