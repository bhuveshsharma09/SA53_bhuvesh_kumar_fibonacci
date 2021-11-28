package com.example.program;

import com.example.config.CustomConfig;
import com.example.resources.AppResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.server.HttpConfiguration;

import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Program extends Application<CustomConfig>{
    public static void main(String[] args) throws Exception {
        // configure to map proper port number
        String applicationPort = "9090";
        String adminPort = "9091";

        System.setProperty("dw.server.applicationConnectors[0].port", applicationPort);
        System.setProperty("dw.server.adminConnectors[0].port", adminPort);
        new Program().run(args);
    }


    @Override
    public void run(CustomConfig customConfig, Environment environment) throws Exception {
        //System.out.println("hello world");

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        // link: https://stackoverflow.com/questions/25775364/enabling-cors-in-dropwizard-not-working
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        // DO NOT pass a preflight request to down-stream auth filters
        // unauthenticated preflight requests should be permitted by spec
        cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());









        environment.jersey().register(new AppResource());


    }
}
