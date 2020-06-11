package org.malicankaya.services;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class LokumInit implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(LokumConfig.class);

        DispatcherServlet dServlet = new DispatcherServlet(webContext);

        ServletRegistration.Dynamic servletReg = servletContext.addServlet("dispatcherServlet", dServlet);

        servletReg.setLoadOnStartup(1);
        servletReg.addMapping("/");


    }
}
