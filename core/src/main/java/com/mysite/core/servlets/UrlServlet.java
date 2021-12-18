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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Component(immediate = true, service = Servlet.class, property = {
        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/urlservlet",
        Constants.SERVICE_DESCRIPTION + "= Servlet for urlservlet",
        Constants.SERVICE_VENDOR + "= mysite"
})

public class UrlServlet extends SlingAllMethodsServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(UrlServlet.class);
    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response){

        try {
            StringBuffer url = request.getRequestURL();
            url.toString();
            response.getWriter().print("current page url is - "+url);
        } catch (Exception e) {
            LOGGER.error("Failed to execute URLservlet");
        }


    }
}
