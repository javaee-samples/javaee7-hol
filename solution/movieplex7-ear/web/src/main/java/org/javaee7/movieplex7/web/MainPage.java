package org.javaee7.movieplex7.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.javaee7.movieplex7.entities.Movie;

/**
 * @author Arun Gupta
 */
@Named
@RequestScoped
public class MainPage {
    Client client;
    WebTarget movieTarget;
    WebTarget theaterTarget;
    
    @Inject HttpServletRequest httpServletRequest;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        movieTarget = client
                .target("http://" +
                httpServletRequest.getLocalName() +
                ":" +
                httpServletRequest.getLocalPort() +
                "/rest/webresources/movie/");
        theaterTarget = client
                .target("http://" +
                httpServletRequest.getLocalName() +
                ":" +
                httpServletRequest.getLocalPort() +
                "/rest/webresources/theater/");
    }
    
    public String moviesCount() {
        // movieFacadeREST.countREST()
        return movieTarget
                .path("count")
                .request()
                .get(String.class);
    }
    
    public String theaterCount() {
        // theaterFacadeREST.countREST()
        return theaterTarget
                .path("count")
                .request()
                .get(String.class);
    }
}
