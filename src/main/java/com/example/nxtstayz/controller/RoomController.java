/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.nxtstayz.*;
import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;

import java.util.ArrayList;

@RestController
public class RoomController {

    private static final RoomController RoomJpaService = null;
	private int hotelId;

    @Autowired
    private RoomJpaService. RoomJpaService;

    @GetMapping("/hotels/rooms")
    public ArrayList<Hotel> getRooms() {
        return RoomJpaService.getRooms();
    }

    @GetMapping("/hotels/{hotelId}")
    public Room getRoomById(@PathVariable("roomId") int roomId) {
        return RoomJpaService.getRoombyId(roomId);
    }

    @PostMapping("/hotels/rooms")
    public String addMultipleRooms(@RequestBody ArrayList<Room> hotelsList) {
        return RoomJpaService.addMultipleRooms(hotelsList);
    }

    @PutMapping("/hotels/rooms/{roomId}")
    public Room updateStudent(@PathVariable("roomId") int roomId, @RequestBody Room room) {
        return RoomJpaService.updateRoom(roomId, room);
    }

    @DeleteMapping("/hotels/rooms/{roomId}")
    public void deleteRoom(@PathVariable int roomId) {
        RoomJpaService.deleteRoom(roomId);
    }

    @GetMapping(" /rooms/{roomId}/hotel")
    public Room getRoomById(@PathVariable("roomId") int roomId) {
        return RoomJpaService.getRoomId(roomId);
    }

}
