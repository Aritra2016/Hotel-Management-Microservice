package com.aritra.Hotel.Service.Dto;

import lombok.Data;

@Data
public class UpdateHotelAddressDto {

    private String address;
    private String city;
    private int postalCode;
    private boolean isAvailable;

}
