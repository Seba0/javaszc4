package seba0.javaszc4.hotel.server.service;

import seba0.javaszc4.hotel.server.model.entity.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {

    List<Guest> getAllGuests();

    Optional<Guest> getGuestById(long id);

    void saveOrUpdateGuest(Guest guest);

    void deleteGuest(Guest guest);

}
