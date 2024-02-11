/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.nxtstayz.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.nxtstayz.model.Hotel;

public class HotelRepository implements RowMapper<Hotel> {

    public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Hotel(
                rs.getInt("hotelId"),
                rs.getString("hotelName"),
                rs.getString("location"),
                rs.getInt("rating"));
    }
}