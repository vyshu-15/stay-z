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

import com.example.nxtstayz.model.Room;

public class RoomRepository implements RowMapper<Room> {

    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Room(
                rs.getInt("roomId"),
                rs.getString("roomName"),
                rs.getString("roomtype"),
                rs.getDouble("price"), rowNum);
    }
}