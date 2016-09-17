package es.uem.aju.rp.business;

import es.uem.aju.common.dto.CompanyDTO;
import es.uem.aju.common.dto.CompanyListDTO;

public interface CompanyServiceRemote {

	public CompanyDTO find(Integer pk);
	
	public CompanyListDTO findAll();
	
	public CompanyDTO findCompanyByName(String name);
	
}
