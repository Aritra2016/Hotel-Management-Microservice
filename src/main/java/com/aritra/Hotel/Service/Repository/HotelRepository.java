package com.aritra.Hotel.Service.Repository;

import com.aritra.Hotel.Service.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
