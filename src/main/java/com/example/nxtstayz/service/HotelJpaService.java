/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.nxtstayz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxtstayz.model.Hotel;
import java.util.ArrayList;

@Service
public class HotelJpaService implements HotelJpaService {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Hotel> getHotels() {
        return (ArrayList<Hotel>) db.query("select * from hotel", new HotelJpaService());
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        try {
            return db.queryForObject("select * from hotel where hotelId = ?", new HotelJpaService(), hotelId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Hotel addSingleHotel(Hotel hotel) {
        db.update("insert into hotel(hotelName,location,rating) values (?,?,?)", student.getHotelName(),
                hotel.getLocation(), hotel.getHotels());
        return db.queryForObject("select * from hotel where hotelName = ? and location = ? and rating = ?",
                new HotelJpaService(), hotel.getHotelName(), hotel.getLocation(), hotel.getRating());
    }

    @Override
    public String addMultipleHotelString(ArrayList<Hotel> hotelsList) {
        for (Hotel eachHotel : hotelsList) {
            db.update("insert into hotel(hotelName,location,rating) values (?,?,?)", eachHotel.getHotelName(),
                    eachHotel.getLocation(), eachHotel.getRating());
        }

        String responseMessage = String.format("Successfully added %d hotels", hotelsList.size());

        return responseMessage;
    }

    @Override
    public Hotel updateHotel(int hotelId, Hotel hotel) {
        if (hotel.getHotelName() != null) {
            db.update("update hotel set hotelName = ? where hotelId = ?", hotel.getHotelName(), hotelId);
        }
        if (hotel.getLocation() != null) {
            db.update("update hotel set location = ? where hotelId = ?", hotel.getLocation(), hotelId);
        }
        if (hotel.getRating() != 0) {
            db.update("update hotel set rating = ? where hotelId = ?", hotel.getRating(), hotelId);
        }
        return getHotelById(hotelId);
    }
