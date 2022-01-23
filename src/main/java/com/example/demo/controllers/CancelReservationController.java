package com.example.demo.controllers;

import com.example.demo.exceptions.BookingException;
import com.example.demo.responses.BookingResponse;
import com.example.demo.services.CancelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class CancelReservationController {

    @Autowired
    CancelReservationService cancelReservationService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                cancelReservationService.deleteReservation(locator));
    }

}
