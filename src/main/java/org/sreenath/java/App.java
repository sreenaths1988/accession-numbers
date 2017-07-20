package org.sreenath.java;

import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * App class - Contains main method which takes care of command line requests and starts embedded server
 *	
 */
public class App
{
    public static void main( String[] args ) throws Exception
    {
    	
    	//String inputArgs = "A00000, A0001, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1";
    	
    	if(args.length == 0) {
    		
    		System.out.println("Please provide list of accession number as comma separated values as argument 1");
    		System.out.println("Listening to embedded server requests");
    		
    		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");

            Server jettyServer = new Server(8080);
            jettyServer.setHandler(context);

            ServletHolder jerseyServlet = context.addServlet(
                 org.glassfish.jersey.servlet.ServletContainer.class, "/*");
            jerseyServlet.setInitOrder(0);

            // Tells the Jersey Servlet which REST service/class to load.
            jerseyServlet.setInitParameter(
               "jersey.config.server.provider.classnames",
               Root.class.getCanonicalName());

            try {
                jettyServer.start();
                jettyServer.join();
            } finally {
                jettyServer.destroy();
            }
    	
    	} else {
    		
    		String resultString = String.join(",", AccessionNumber.getOrderedList(args[0]));
    		System.out.println("Results");
        	System.out.println(resultString);
        	
    	}	
        
    }
    
    public static List<String> getOrderedList(String arg) {
    	
    	return AccessionNumber.getOrderedList(arg);
    	
    }

}
