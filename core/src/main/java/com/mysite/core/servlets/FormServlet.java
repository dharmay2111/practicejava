package com.mysite.core.servlets;

import acscommons.com.jcraft.jsch.Logger;

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
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@Component(immediate = true, service = Servlet.class, property = {
        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/formservlet",
        Constants.SERVICE_DESCRIPTION + "= Servlet for formservlet",
        Constants.SERVICE_VENDOR + "= mysite"
})
public class FormServlet extends SlingAllMethodsServlet {
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FormServlet.class);
    ResourceResolver resourceResolver;
    @Reference
    ResourceResolverFactory resourceResolverFactory;


    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        try {
            if (height.matches("[0-9]+") && weight.matches("[0-9]+")) {
                double bmi = calculateBMI(
                        Double.parseDouble(weight),
                        Double.parseDouble(height));
                resourceResolver = getServiceUser(resourceResolverFactory);
                String path = "/content/mysite/us/en";
                Session session = resourceResolver.adaptTo(Session.class);
                if (session != null) {
                    Node node = session.getNode(path);
                    node.addNode("Dharma");
                   /* node.setProperty("weight",weight);
                    node.setProperty("height",height);*/
                }
                session.save();

                response.getWriter().print("This is test servlet -" + height + "location -" + weight + "=bmi=" + bmi); //print the response
            } else {
                LOGGER.error("please provide valid input");
            }
        } catch (Exception e) {
            LOGGER.error("error in form.");
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

    public ResourceResolver getServiceUser(ResourceResolverFactory resourceResolverFactory) throws LoginException {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put(ResourceResolverFactory.SUBSERVICE, "getResourceResolver");
        resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
        return resourceResolver;
    }

}

