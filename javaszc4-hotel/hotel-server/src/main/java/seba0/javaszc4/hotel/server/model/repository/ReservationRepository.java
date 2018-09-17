package seba0.javaszc4.hotel.server.model.repository;


import org.springframework.data.repository.CrudRepository;
import seba0.javaszc4.hotel.server.model.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
