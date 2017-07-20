package org.sreenath.java;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/root")
public class Root {
	
	/*
	 * Invoked while using web interface
	 */
	
	@POST
	@Path("/accessionnumber")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String returnOrderedListHTMLForm(@FormParam("input_text") String input) {
		
		StringBuffer results = new StringBuffer();
		
		results.append("<html><head><title>Accession Number Web Application</title></head>");
		results.append("<body>");
		results.append("<h4>Results</h4>");
		results.append(String.join(",", App.getOrderedList(input)));
		results.append("</body></html>");
		
		return results.toString();
		
	}
	
	/*
	 * Invoked during REST API call
	 */
	
	@POST
	@Path("/accessionnumber")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_PLAIN)
	public String returnOrderedListPlainText(String input) {
		
		return String.join(",", App.getOrderedList(input));
		
		
	}
	
}
