package com.mysite.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(immediate = true, service = Servlet.class, property = {
        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/testservlet",
        Constants.SERVICE_DESCRIPTION + "= Servlet for testservlet",
        Constants.SERVICE_VENDOR + "= mysite"
})
public class TestServlet extends SlingAllMethodsServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestServlet.class); //final keyword is used so that no one changes the variable value latter on.variable value cannot be over ride.
    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response){
        String name = request.getParameter("name");
        String location = request.getParameter("location");//to get the request parameter
        try{
            response.getWriter().print("This is test servlet -"+name + "location -"+location); //print the response
        } catch (IOException e) {
            LOGGER.error("Failed to execute TestServlet");
        }
    }
}
