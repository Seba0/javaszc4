package seba0.javaszc4.hotel.server.service;

import seba0.javaszc4.hotel.server.model.entity.Reservation;
import seba0.javaszc4.hotel.server.model.entity.Room;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Optional<Reservation> getReservationById(long id);

    void saveOrUpdateReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);

    List<Reservation> getReservationByRoom(Room room);
}
