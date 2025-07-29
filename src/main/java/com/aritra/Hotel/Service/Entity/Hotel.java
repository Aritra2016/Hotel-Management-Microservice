package com.aritra.Hotel.Service.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Data
public class Hotel {
 //@Data= combitionation of Getter,Setter,AllArg,NoArg
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    private String address;
    private int postalCode;
    private float rating;
    private boolean isAvailable;


}



