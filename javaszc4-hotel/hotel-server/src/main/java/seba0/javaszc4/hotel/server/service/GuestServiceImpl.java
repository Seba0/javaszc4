package seba0.javaszc4.hotel.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seba0.javaszc4.hotel.server.model.entity.Guest;
import seba0.javaszc4.hotel.server.model.repository.GuestRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Guest> getAllGuests() {
        return (List<Guest>) guestRepository.findAll();
    }

    @Override
    public Optional<Guest> getGuestById(long id) {
        return guestRepository.findById(id);
    }

    @Override
    public void saveOrUpdateGuest(Guest guest) {
        guestRepository.save(guest);
    }

    @Override
    public void deleteGuest(Guest guest) {
        guestRepository.delete(guest);
    }
}
