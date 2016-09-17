package es.uem.aju.common.dao.interfaces;

import es.uem.aju.common.dao.base.GenericDAO;
import es.uem.aju.common.dto.CompanyDTO;

public interface CompanyDAO extends GenericDAO<CompanyDTO, Integer>{
	
	public CompanyDTO findCompanyByName(String name);
}
