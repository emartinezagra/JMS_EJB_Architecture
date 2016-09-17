package es.uem.aju.rt.web.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpStatus;

import es.uem.aju.common.dto.CompanyDTO;
import es.uem.aju.common.dto.CompanyListDTO;
import es.uem.aju.common.util.JSONObjectParser;
import es.uem.aju.common.util.StringUtils;
import es.uem.aju.rp.business.CompanyServiceLocal;

@Stateless
@Path("/company")
public class CompanyWS extends BaseWS{

	@EJB
	CompanyServiceLocal companyService;
	
	@GET
    @Path("/{pathParameter}")
    public Response responseFindResource( 
    		@PathParam("pathParameter") 
    		String pathParameter) {
			
		log.debug("Request received by "+this.getClass().getName());
        log.info("Looking for : " + pathParameter);
        if (StringUtils.isNumber(pathParameter)){
        	CompanyDTO company = companyService.find(Integer.parseInt(pathParameter));
        	return Response.status(HttpStatus.SC_OK).entity(JSONObjectParser.fromObjectToJson(company)).build();
        }else{
        	return Response.status(HttpStatus.SC_OK).entity(RESOURCE_NOT_FOUND).build();
        }                
    }
		
	@GET
    @Path("/")
    public Response responseFindAllRecources() {
		log.debug("Request received by "+this.getClass().getName());		
		CompanyListDTO companies = companyService.findAll();
		return Response.status(HttpStatus.SC_OK).entity(JSONObjectParser.fromObjectToJson(companies)).build();					                              
    }
}
