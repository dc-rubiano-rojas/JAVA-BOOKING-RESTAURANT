package com.example.demo.controllers;

import com.example.demo.exceptions.BookingException;
import com.example.demo.jsons.RestaurantRest;
import com.example.demo.responses.BookingResponse;
import com.example.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId" + "/}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<RestaurantRest> getRestaurantById(Long restaurantId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingException {
        return new BookingResponse<List<RestaurantRest>>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurants());
    }
}
