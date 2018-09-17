package seba0.javaszc4.hotel.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.hotel.server.model.entity.Guest;
import seba0.javaszc4.hotel.server.service.GuestService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Guest> list() {
        return guestService.getAllGuests();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Guest edit(@PathVariable long id) {
        Optional<Guest> guestById = guestService.getGuestById(id);
        return guestById.orElse(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Guest guest) {
        if(guest.getId() > 0) {
            return false;
        }
        guest.setRegistrationDate(new Date());
        guestService.saveOrUpdateGuest(guest);
        return true;
    }
}
