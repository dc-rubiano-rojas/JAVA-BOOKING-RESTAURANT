package com.example.demo.services.impl;

import com.example.demo.entities.Reservation;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Turn;
import com.example.demo.exceptions.BookingException;
import com.example.demo.exceptions.InternalServerErrorException;
import com.example.demo.exceptions.NotFountException;
import com.example.demo.jsons.CreateReservationRest;
import com.example.demo.jsons.ReservationRest;
import com.example.demo.respositories.ReservationRepository;
import com.example.demo.respositories.RestaurantRepository;
import com.example.demo.respositories.TurnRepository;
import com.example.demo.services.ReservationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private TurnRepository turnRepository;

    public static final ModelMapper modelMapper = new ModelMapper();


    public ReservationRest getReservation(Long reservationId) throws BookingException {
        return modelMapper.map(getReservationEntity(reservationId), ReservationRest.class);
    }

    private Reservation getReservationEntity(Long reservationId) throws BookingException {
        return reservationRepository.findById(reservationId)
                .orElseThrow( () -> new NotFountException("404", "User Not Found"));
    }

    public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

        final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
                .orElseThrow(() -> new NotFountException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));

        final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
                .orElseThrow(() -> new NotFountException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));

        String locator = generateLocator(restaurantId, createReservationRest);
        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson());
        reservation.setDate(createReservationRest.getDate());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turn.getName());

        try {
            reservationRepository.save(reservation);
        } catch(final Exception e) {
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return locator;
    }

    private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest) throws BookingException {
        return restaurantId.getName() + createReservationRest.getTurnId();
    }


}
