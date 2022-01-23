package com.example.demo.services.impl;

import com.example.demo.entities.Restaurant;
import com.example.demo.exceptions.BookingException;
import com.example.demo.exceptions.NotFountException;
import com.example.demo.jsons.RestaurantRest;
import com.example.demo.respositories.RestaurantRepository;
import com.example.demo.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Repository
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }

    public List<RestaurantRest> getRestaurants() throws BookingException {
        final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestaurantRest.class) ).collect(Collectors.toList());
    }

    private Restaurant getRestaurantEntity(Long  restaurantId) throws BookingException {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow( () -> new NotFountException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
    }

}
