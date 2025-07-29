package com.aritra.Hotel.Service.service;

import com.aritra.Hotel.Service.Dto.HotelDto;
import com.aritra.Hotel.Service.Entity.Hotel;
import com.aritra.Hotel.Service.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class HotelServiceImpl implements  HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(HotelDto hoteldto) {
        Hotel hotel=new Hotel();
        hotel.setAddress(hoteldto.getAddress());
        hotel.setName(hoteldto.getName());
        hotel.setCity(hoteldto.getCity());
        hotel.setAvailable(hoteldto.isAvailable());
        hotel.setPostalCode(hoteldto.getPostalCode());
        hotel.setRating(hoteldto.getRating());

        //save in repository
        hotelRepository.save(hotel);
        return hotel;

    }

    @Override
    public Hotel getAllHotel(HotelDto hoteldto) {
        return null;
    }
}
