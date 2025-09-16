package com.aritra.Hotel.Service.service;

import com.aritra.Hotel.Service.Dto.HotelDto;
import com.aritra.Hotel.Service.Dto.UpdateHotelAddressDto;
import com.aritra.Hotel.Service.Entity.Hotel;
import com.aritra.Hotel.Service.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HotelServiceImpl implements  HotelService{

    @Autowired
     HotelRepository hotelRepository;


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
    public List<Hotel> getAllHotels( ) {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById( long id) {
        return hotelRepository.findById(id).orElseThrow(()-> new RuntimeException("Hotel not found"));
    }


    @Override
    public Hotel updateHotelAddress(UpdateHotelAddressDto updateHotelAddressDto, long id) {
        Hotel hotel= getHotelById(id);
        if(hotel != null){
            hotel.setAddress(updateHotelAddressDto.getAddress());
            hotel.setCity(updateHotelAddressDto.getCity());
            hotel.setPostalCode(updateHotelAddressDto.getPostalCode());

            return hotelRepository.save(hotel);

        }
        else{
            return null;
        }

    }

    @Override
    public Hotel updateHotel(HotelDto hotelDto, long id) {
        Hotel hotel= getHotelById(id);

        if(hotel != null){
            hotel.setAddress(hotelDto.getAddress());
            hotel.setName(hotelDto.getName());
            hotel.setCity(hotelDto.getCity());
            hotel.setAvailable(hotelDto.isAvailable());
            hotel.setPostalCode(hotelDto.getPostalCode());
            hotel.setRating(hotelDto.getRating());

            hotelRepository.save(hotel);
        }
        else {
            return null;
        }


        return hotel;
    }

    @Override
    public void deleteHotel(long id) {
        Hotel hotel= getHotelById(id);
        if(hotel != null){
            hotelRepository.deleteById(id);
        }
    }


}
