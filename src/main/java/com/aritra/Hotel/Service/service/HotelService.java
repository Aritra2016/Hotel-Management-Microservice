package com.aritra.Hotel.Service.service;

import com.aritra.Hotel.Service.Dto.HotelDto;
import com.aritra.Hotel.Service.Dto.UpdateHotelAddressDto;
import com.aritra.Hotel.Service.Entity.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {

   public Hotel saveHotel(HotelDto hoteldto); //passing HotelDt
    List<Hotel> getAllHotels( );
 public ResponseEntity<Hotel> getHotelById(long id) ;
    public void deleteHotel(long id);
    public Hotel updateHotelAddress(UpdateHotelAddressDto updateHotelAddressDto, long id);
    public ResponseEntity<Hotel> updateHotel(HotelDto hotelDto,long  id);


}
