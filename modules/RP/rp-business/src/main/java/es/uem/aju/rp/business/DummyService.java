package es.uem.aju.rp.business;


import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.annotation.PostConstruct;

import es.uem.aju.common.dao.CompanyDAOMySQL;
import es.uem.aju.common.dao.factory.CompanyDAOFactory;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dao.interfaces.CompanyDAO;
import es.uem.aju.common.dto.CompanyDTO;
import es.uem.aju.rp.business.DummyLocal;
import es.uem.aju.rp.business.DummyRemote;

@Stateless( name = "DummyService" )
@Local( DummyLocal.class )
@Remote( DummyRemote.class )
public class DummyService implements DummyLocal{

	
	private CompanyDAOMySQL companyDAO;
	
	@PostConstruct
	public void postConstruct(){
		CompanyDAOFactory daoFactory = new CompanyDAOFactory();
		companyDAO = daoFactory.getDAO(DatasourceMySQLFactory.MY_SQL);
	}
		
	
	/**
	 * Checking DB connectivity and DAO Injection
	 */
	public String dummyJDBCMethod(){
		
		List<CompanyDTO> results = (List<CompanyDTO>) companyDAO.findCompanyByName("Bank of Scotland");
		StringBuilder sb = new StringBuilder("Company found: ");
		if (results != null){
			for (CompanyDTO company : results){
				sb.append(company.getName());							
			}	
		}		
		return sb.toString();							
	}
}
