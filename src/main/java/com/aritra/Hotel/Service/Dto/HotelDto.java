package com.aritra.Hotel.Service.Dto;

import lombok.Data;

@Data
public class HotelDto {

    private String name;
    private String city;
    private String address;
    private int postalCode;
    private float rating;
    private boolean isAvailable;

}
