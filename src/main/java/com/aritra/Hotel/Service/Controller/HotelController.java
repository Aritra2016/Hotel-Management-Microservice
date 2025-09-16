package com.aritra.Hotel.Service.Controller;

import com.aritra.Hotel.Service.Dto.HotelDto;
import com.aritra.Hotel.Service.Dto.UpdateHotelAddressDto;
import com.aritra.Hotel.Service.Entity.Hotel;
import com.aritra.Hotel.Service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/createhotel")
    public Hotel createHotel(@RequestBody HotelDto hotelDto){
      return  hotelService.saveHotel(hotelDto);

    }

    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotels( ){
        return  hotelService.getAllHotels();
    }

    @GetMapping("/getHotel/{id}")
    public Hotel getHotelById(@PathVariable  long id){
        return  hotelService.getHotelById(id);
    }

    @PutMapping("/updatehotel/{id}")
    public Hotel updateHotel( @RequestBody HotelDto hotelDto  ,@PathVariable  long id){
        return  hotelService.updateHotel(hotelDto,id);
    }

    @PutMapping("/updatehotelAddress/{id}")
    public Hotel updateHotelAddress(@RequestBody UpdateHotelAddressDto updateHotelAddressDto, @PathVariable long id ){
        return hotelService.updateHotelAddress(updateHotelAddressDto,id);
    }




}
