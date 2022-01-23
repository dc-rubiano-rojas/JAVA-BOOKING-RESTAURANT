package com.example.demo.services;

import com.example.demo.exceptions.BookingException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface CancelReservationService {

    public String deleteReservation(String locator) throws BookingException;
}
