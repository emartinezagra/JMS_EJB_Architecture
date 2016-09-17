package es.uem.aju.rt.web.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpStatus;

import es.uem.aju.common.dto.ActivityDTO;
import es.uem.aju.common.dto.ActivityListDTO;
import es.uem.aju.common.util.JSONObjectParser;
import es.uem.aju.common.util.StringUtils;
import es.uem.aju.rp.business.ActivityServiceLocal;

@Stateless
@Path("/activity")
public class ActivityWS extends BaseWS {

	@EJB
	ActivityServiceLocal activityService;

	@GET
	@Path("/{pathParameter}")
	public Response responseFindResource(@PathParam("pathParameter") String pathParameter) {

		log.debug("Request received by " + this.getClass().getName());
		log.info("Looking for : " + pathParameter);
		if (StringUtils.isNumber(pathParameter)) {
			ActivityDTO activity = activityService.find(Integer.parseInt(pathParameter));
			return Response.status(HttpStatus.SC_OK).entity(JSONObjectParser.fromObjectToJson(activity)).build();
		} else {
			return Response.status(HttpStatus.SC_OK).entity(RESOURCE_NOT_FOUND).build();
		}
	}

	@GET
	@Path("/")
	public Response responseFindAllRecources() {
		log.debug("Request received by " + this.getClass().getName());
		ActivityListDTO activities = activityService.findAll();
		return Response.status(HttpStatus.SC_OK).entity(JSONObjectParser.fromObjectToJson(activities)).build();
	}

}
