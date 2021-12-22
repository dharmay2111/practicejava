package com.mysite.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.HashMap;

@Component(immediate = true, service = Servlet.class, property = {
        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/testservlet",
        Constants.SERVICE_DESCRIPTION + "= Servlet for testservlet",
        Constants.SERVICE_VENDOR + "= mysite"
})
public class TestServlet extends SlingAllMethodsServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestServlet.class); //final keyword is used so that no one changes the variable value latter on.variable value cannot be over ride.
    ResourceResolver resourceResolver;
    @Reference
    ResourceResolverFactory resourceResolverFactory;
    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String location = request.getParameter("location");//to get the request parameter
        try{ resourceResolver= getServiceUser(resourceResolverFactory);
            String path="/content/mysite/us/fr";
            Session session = resourceResolver.adaptTo(Session.class);
            if (session != null) {
                Node node = session.getNode(path);
                node.addNode("Dharmay");
                   /* node.setProperty("weight",weight);
                    node.setProperty("height",height);*/

                session.save();
                Resource resource = resourceResolver.getResource("path");
                response.getWriter().print("This is test servlet -" + name + "location -" + location); //print the response
            }else{
            LOGGER.error("please provide valid input");
        }
        } catch (Exception e) {
            LOGGER.error("Failed to execute TestServlet");
        }
    }
    public  ResourceResolver getServiceUser(ResourceResolverFactory resourceResolverFactory) throws LoginException {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put(ResourceResolverFactory.SUBSERVICE, "getResourceResolver");
         resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
        return resourceResolver;
    }
}
