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

@Repository
public interface RoomJpaRepository<Room> {
    ArrayList<Room> getRoomss();

    Room getRoomById(int roomId);

    Room addSingleRoom(Room room);

    String addMultipleRooms(ArrayList<Room> roomsList);

    Room updateRoom(int roomId, Room room);

    void deleteRoom(int RoomId);

}