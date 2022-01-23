package com.example.demo.controllers;

import com.example.demo.exceptions.BookingException;
import com.example.demo.jsons.CreateReservationRest;
import com.example.demo.jsons.ReservationRest;
import com.example.demo.responses.BookingResponse;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                reservationService.createReservation(createReservationRest));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation" + "/{" + "reservationId" + "/}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<ReservationRest> getRestaurantById(Long reservationId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                reservationService.getReservation(reservationId));
    }

}
