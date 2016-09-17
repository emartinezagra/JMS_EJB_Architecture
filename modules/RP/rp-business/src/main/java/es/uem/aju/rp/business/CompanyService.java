package es.uem.aju.rp.business;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import es.uem.aju.common.dao.CompanyDAOMySQL;
import es.uem.aju.common.dao.factory.CompanyDAOFactory;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.CompanyDTO;
import es.uem.aju.common.dto.CompanyListDTO;

@Stateless( name = "CompanyService" )
@Local( CompanyServiceLocal.class )
@Remote( CompanyServiceRemote.class )
public class CompanyService implements CompanyServiceLocal {

	private CompanyDAOMySQL companyDAO;
	
	@PostConstruct
	public void postConstruct(){
		CompanyDAOFactory daoFactory = new CompanyDAOFactory();
		companyDAO = daoFactory.getDAO(DatasourceMySQLFactory.MY_SQL);
	}
		
	public CompanyDTO find(Integer pk) {
		return companyDAO.find(pk);
	}

	public CompanyDTO findCompanyByName(String name) {
		return companyDAO.findCompanyByName(name);
	}

	public CompanyListDTO findAll() {		
		return companyDAO.findAll();
	}
}
