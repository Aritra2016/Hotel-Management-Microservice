package com.aritra.Hotel.Service.service;

import com.aritra.Hotel.Service.Dto.HotelDto;
import com.aritra.Hotel.Service.Entity.Hotel;
import org.springframework.stereotype.Service;


public interface HotelService {

   public Hotel saveHotel(HotelDto hoteldto); //passing HotelDt

    public Hotel getAllHotel(HotelDto hoteldto);


}
