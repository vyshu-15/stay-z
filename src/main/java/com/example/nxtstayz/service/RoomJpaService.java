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

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.repository.RoomJpaRepository;

@Service
public class RoomJpaService implements Repository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Room> getRoomss() {
        return (ArrayList<Room>) db.query("select * from room", new RoomJpaService());
    }

    @Override
    public Hotel getRoomById(int roomId) {
        try {
            return db.queryForObject("select * from room where roomId = ?", new Repository(), roomId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Hotel addSingleRoom(Room room) {
        db.update("insert into room(roomName,,roomtype) values (?,?,?)", room.getRoomName(),
                room.getRoomType(), room.getPrice());
        return db.queryForObject("select * from room where roomName = ? and roomtype = ? and price = ?",
                new Repositor(), room.getRoomName(), room.getRoomType(), room.getPrice());
    }

    @Override
    public String addMultipleRooms(ArrayList<Room> roomsList) {
        for (Room eachRoom : roomsList) {
            db.update("insert into room(roomName,roomtype,price) values (?,?,?)", eachRoom.getRoomName(),
                    eachRoom.getRoomType(), eachRoom.getPrice());
        }

        String responseMessage = String.format("Successfully added %d rooms", roomsList.size());

        return responseMessage;
    }

    @Override
    public Room updateStudent(int roomId, Room room) {
        if (room.getRoomName() != null) {
            db.update("update room set roomName = ? where roomId = ?", room.getRoomName(), roomId);
        }
        if (room.getRoomType() != null) {
            db.update("update room set roomtype = ? where roomId = ?", room.getRoomType(), roomId);
        }
        if (room.getPrice() != 0) {
            db.update("update room set price = ? where roomId = ?", room.getPrice(), roomId);
        }
        return getRoomById(roomId);
    }
