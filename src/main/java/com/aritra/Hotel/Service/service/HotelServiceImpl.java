package com.aritra.Hotel.Service.service;

import com.aritra.Hotel.Service.Communicator.RestTemplateCommunicator;
import com.aritra.Hotel.Service.Dto.HotelDto;
import com.aritra.Hotel.Service.Dto.UpdateHotelAddressDto;
import com.aritra.Hotel.Service.Entity.Hotel;
import com.aritra.Hotel.Service.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class HotelServiceImpl implements  HotelService{

    @Autowired
     HotelRepository hotelRepository;

    @Autowired
    RestTemplateCommunicator restTemplateCommunicator;

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
    public ResponseEntity<Hotel> getHotelById(long id) {
      Optional<Hotel> hotelBox = hotelRepository.findById(id);

      Float hotelActualRating= restTemplateCommunicator.getActualHotelBooking(id);
     Hotel hotel = hotelBox.get();
     hotel.setRating(hotelActualRating);


      if(!hotelBox.isPresent()){
          return new ResponseEntity<>(hotel, HttpStatus.NOT_FOUND);
      }else{
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

    }
    @Override
    public Hotel updateHotelAddress(UpdateHotelAddressDto updateHotelAddressDto, long id) {
        Hotel hotel= getHotelById(id).getBody();
        if(hotel != null){
            hotel.setAddress(updateHotelAddressDto.getAddress());
            hotel.setCity(updateHotelAddressDto.getCity());
            hotel.setPostalCode(updateHotelAddressDto.getPostalCode());
            hotel.setRating(Float.parseFloat(updateHotelAddressDto.getAddress()));

            return hotelRepository.save(hotel);

        }
        else{
            return null;
        }

    }

    @Override
    public ResponseEntity<Hotel> updateHotel(HotelDto hotelDto, long id) {
        Optional<Hotel> hotelBox = hotelRepository.findById(id);
        Hotel hotel= new Hotel();

        if(hotelBox.isPresent()){
            // hotel.setAddress(hotelDto.getAddress());
            hotel.setName(hotelDto.getName());
            hotel.setAddress(hotelDto.getAddress());
            hotel.setCity(hotelDto.getCity());
            hotel.setAvailable(hotelDto.isAvailable());
            hotel.setPostalCode(hotelDto.getPostalCode());
            hotel.setRating(hotelDto.getRating());

            hotelRepository.save(hotel);
            return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(hotel, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteHotel(long id) {
        Hotel hotel= getHotelById(id).getBody();
        if(hotel != null){
            hotelRepository.deleteById(id);
        }
    }


}
