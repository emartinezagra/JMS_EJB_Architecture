package es.uem.aju.rt.web.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpStatus;

import es.uem.aju.common.dto.EquipmentDTO;
import es.uem.aju.common.dto.EquipmentListDTO;
import es.uem.aju.common.util.JSONObjectParser;
import es.uem.aju.common.util.StringUtils;
import es.uem.aju.rp.business.EquipmentServiceLocal;

@Stateless
@Path("/equipment")
public class EquipmentWS extends BaseWS{
	
	@EJB
	EquipmentServiceLocal equipmentService;

	@GET
    @Path("/{pathParameter}")
    public Response responseFindResource( 
    		@PathParam("pathParameter") 
    		String pathParameter) {
		log.debug("Request received by "+this.getClass().getName());
        log.info("Looking for : " + pathParameter);
        if (StringUtils.isNumber(pathParameter)){
        	EquipmentDTO equipment = equipmentService.find(Integer.parseInt(pathParameter));
        	return Response.status(HttpStatus.SC_OK).entity(JSONObjectParser.fromObjectToJson(equipment)).build();
        }else{
        	return Response.status(HttpStatus.SC_OK).entity(RESOURCE_NOT_FOUND).build();	
        }        
    }
		
	@GET
    @Path("/")
    public Response responseFindAllRecources() {
		log.debug("Request received by "+this.getClass().getName());		
		EquipmentListDTO equipments = equipmentService.findAll();
		return Response.status(HttpStatus.SC_OK).entity(JSONObjectParser.fromObjectToJson(equipments)).build();					                              
    }
	
}
