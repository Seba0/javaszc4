package seba0.javaszc4.hotel.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seba0.javaszc4.hotel.server.model.entity.Room;
import seba0.javaszc4.hotel.server.model.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomByNr(short nr) {
        return roomRepository.findById(nr);
    }

    @Override
    public void saveOrUpdateRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }
}
