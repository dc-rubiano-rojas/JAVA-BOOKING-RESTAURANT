package com.example.demo.controllers;

import com.example.demo.exceptions.BookingException;
import com.example.demo.jsons.RestaurantRest;
import com.example.demo.jsons.TurnRest;
import com.example.demo.responses.BookingResponse;
import com.example.demo.services.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RestaurantControllerTests {

    public static final RestaurantRest RESTAURANT_REST = new RestaurantRest();
    public static final long RESTAURANT_ID = 1L;
    public static final String NAME = "Daniel";
    public static final String DESCRIPTION = "Todo tipo de Hamburguesas";
    public static final String ADDRESS = "Calle 100";
    public static final String IMAGE = "my-image.jpg";
    public static final List<TurnRest> TURN_LIST = new ArrayList<>();

    public static final String SUCCESS_STATUS = "Success";
    public static final String SUCCESS_CODE = "200 OK";
    public static final String OK = "OK";


    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        RESTAURANT_REST.setName(NAME);
        RESTAURANT_REST.setDescription(DESCRIPTION);
        RESTAURANT_REST.setAddress(ADDRESS);
        RESTAURANT_REST.setId(RESTAURANT_ID);
        RESTAURANT_REST.setImage(IMAGE);
        RESTAURANT_REST.setTurns(TURN_LIST);

        Mockito.when(restaurantController.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);
    }

    @Test
    public void getRestaurantByIdTest() throws BookingException {
        final BookingResponse<RestaurantRest> response =  restaurantController.getRestaurantById(RESTAURANT_ID);
        assertEquals(response.getStatus(), SUCCESS_STATUS);
        assertEquals(response.getCode(), SUCCESS_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), RESTAURANT_REST);
    }
}
