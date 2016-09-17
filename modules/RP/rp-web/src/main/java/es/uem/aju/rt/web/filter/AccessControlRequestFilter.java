package es.uem.aju.rt.web.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class AccessControlRequestFilter implements ContainerRequestFilter {

	public void filter(ContainerRequestContext request) throws IOException {
		request.getHeaders().add("Access-Control-Allow-Origin", "*");
		request.getHeaders().add("Access-Control-Allow-Headers", "Authorization");
		if (request.getMethod().equals("OPTIONS")) {
			System.out.println("OPTIONS is requested!!!!!!!!!!!!!");
		}
		if (request.getMethod().equals("GET")) {
			System.out.println("GET request");
		}
		if (request.getMethod().equals("POST")) {
			System.out.println("POST request");
		}
		if (request.getMethod().equals("DELETE")) {
			System.out.println("DELETE request");
		}
		if (request.getMethod().equals("PUT")) {
			System.out.println("PUT request");
		}
	}
}
