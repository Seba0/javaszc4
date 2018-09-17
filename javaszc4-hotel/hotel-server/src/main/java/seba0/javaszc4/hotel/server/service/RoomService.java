package seba0.javaszc4.hotel.server.service;


import seba0.javaszc4.hotel.server.model.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getAllRooms();

    Optional<Room> getRoomById(short id);

    void saveOrUpdateRoom(Room guest);

    void deleteRoom(Room guest);

}
