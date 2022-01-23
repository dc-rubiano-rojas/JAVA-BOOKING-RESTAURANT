package com.example.demo.services;

import com.example.demo.exceptions.BookingException;
import com.example.demo.jsons.CreateReservationRest;
import com.example.demo.jsons.ReservationRest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface ReservationService {

    ReservationRest getReservation(Long reservationId) throws BookingException;

    String createReservation(CreateReservationRest CreateReservationRest) throws BookingException;
}
