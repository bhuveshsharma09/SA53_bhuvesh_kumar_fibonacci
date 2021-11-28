package com.example.resources;
import com.example.service.Payload;
import com.example.service.Result;
import com.example.service.ResultService;

import javax.json.Json;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/fibonacci")
    public class AppResource {
    /*
     * This class will define the endpoints of the API
     * */

    @GET
    @Path("/test")
    public String test() {
        // just a simple test end point to check the API
        return "ping at" + new Date();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Result bussinessLogic(Payload payload) {
        /* The endpoint which handles POST method
            for 'fibonacci endpoint */
        // get the json data value from request header
        int element = payload.elements;
        if (element > 0 && element <= 100) {
            ResultService resultService = new ResultService(element);
            System.out.println(payload.elements);

            // process the data in result service object and return the JSON reponse
            return resultService.getTheResult();
        } else {
            Result result = new Result();
            result.fibonacci = (new ArrayList<>() {
            });
            result.sorted = (new ArrayList<>() {
            });

            return result;

        }

    }
}


