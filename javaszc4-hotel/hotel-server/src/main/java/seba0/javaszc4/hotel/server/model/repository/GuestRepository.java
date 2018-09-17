package seba0.javaszc4.hotel.server.model.repository;

import org.springframework.data.repository.CrudRepository;
import seba0.javaszc4.hotel.server.model.entity.Guest;
import seba0.javaszc4.hotel.server.model.entity.Information;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}
