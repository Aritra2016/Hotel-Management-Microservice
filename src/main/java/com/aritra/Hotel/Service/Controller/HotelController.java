package com.aritra.Hotel.Service.Controller;

import com.aritra.Hotel.Service.Dto.HotelDto;
import com.aritra.Hotel.Service.Dto.UpdateHotelAddressDto;
import com.aritra.Hotel.Service.Entity.Hotel;
import com.aritra.Hotel.Service.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")

public class HotelController {

     private Logger logger= LoggerFactory.getLogger(HotelController.class);

    @Autowired
    HotelService hotelService;

    @PostMapping("/createhotel")
    public Hotel createHotel(@RequestBody HotelDto hotelDto){
        logger.info("createHotel");
      return  hotelService.saveHotel(hotelDto);

    }

    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotels( ){
        return  hotelService.getAllHotels();
    }

    @GetMapping("/getHotel/{id}")
    public Hotel getHotelById(@PathVariable  long id){
        return hotelService.getHotelById(id).getBody();
    }

    @PutMapping("/updatehotel/{id}")
    public Hotel updateHotel( @RequestBody HotelDto hotelDto ,@PathVariable  long id){
        return hotelService.updateHotel(hotelDto,id).getBody();
    }

    @PutMapping("/updatehotelAddress/{id}")
    public Hotel updateHotelAddress(@RequestBody UpdateHotelAddressDto updateHotelAddressDto, @PathVariable long id ){
        return hotelService.updateHotelAddress(updateHotelAddressDto,id);
    }

    @DeleteMapping("/deleteHotel/{id}")
    public void deleteHotel(@PathVariable long id){
         hotelService.deleteHotel(id);
    }


}
