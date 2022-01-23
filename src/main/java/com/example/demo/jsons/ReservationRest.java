package com.example.demo.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {

    @JsonProperty("locator")
    private String locator;

    @JsonProperty("restaurantId")
    private Long restaurantId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("person")
    private Long person;

    @JsonProperty("turnId")
    private Long turnId ;

}
