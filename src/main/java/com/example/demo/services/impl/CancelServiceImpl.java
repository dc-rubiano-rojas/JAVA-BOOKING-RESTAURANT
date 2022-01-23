package com.example.demo.services.impl;

import com.example.demo.entities.Restaurant;
import com.example.demo.exceptions.BookingException;
import com.example.demo.exceptions.InternalServerErrorException;
import com.example.demo.exceptions.NotFountException;
import com.example.demo.respositories.ReservationRepository;
import com.example.demo.services.CancelReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class CancelServiceImpl implements CancelReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelServiceImpl.class);

    @Autowired
    ReservationRepository reservationRepository;

    public String deleteReservation(String locator) throws BookingException {

        reservationRepository.findByLocator(locator)
                .orElseThrow(() -> new NotFountException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));

        try {
            reservationRepository.deleteByLocator(locator);
        } catch(Exception e) {
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "LOCATOR_DELETED";
    }
}
