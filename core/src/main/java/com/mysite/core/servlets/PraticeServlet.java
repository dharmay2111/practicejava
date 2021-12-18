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
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/praticeservlet",
        Constants.SERVICE_DESCRIPTION + "= Servlet for testservlet",
        Constants.SERVICE_VENDOR + "= mysite"
})
public class PraticeServlet extends SlingAllMethodsServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(PraticeServlet.class);
    @Override
    protected void doGet(final SlingHttpServletRequest request,final SlingHttpServletResponse report){
        try{
            report.getWriter().print("this is a practice servlet");
        } catch (IOException e) {
           LOGGER.error("Failed to execute practice servlet");
        }
    }
}
