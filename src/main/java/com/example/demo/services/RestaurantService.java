package com.example.demo.services;

import com.example.demo.exceptions.BookingException;
import com.example.demo.jsons.RestaurantRest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface RestaurantService  {

    RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

    public List<RestaurantRest> getRestaurants() throws BookingException;
}
