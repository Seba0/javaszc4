package seba0.javaszc4.hotel.server.model.repository;


import org.springframework.data.repository.CrudRepository;
import seba0.javaszc4.hotel.server.model.entity.Reservation;
import seba0.javaszc4.hotel.server.model.entity.Room;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findAllByRoom(Room room);
}
