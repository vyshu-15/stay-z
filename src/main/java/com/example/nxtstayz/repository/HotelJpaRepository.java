/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here

package com.example.nxtstayz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import com.example.nxtstayz.model.Hotel;

@Repository
public interface HotelJpaRepository {
    ArrayList<Hotel> getHotels();

    Hotel getHotelById(int hotelId);

    String addMultipleHotels(ArrayList<Hotel> hotelsList);

    Hotel updateHotel(int hotelId, Hotel hotel);

    void deleteHotel(int hotelId);

}