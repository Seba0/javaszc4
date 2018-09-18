package seba0.javaszc4.hotel.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseBody
    public List<Guest> list() {
        return guestService.getAllGuests();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Guest getById(@PathVariable("id") long id) {
        Optional<Guest> guest = guestService.getGuestById(id);
        return guest.orElse(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Guest add(@RequestBody Guest guest) {
        guest.setRegistrationDate(new Date());
        guestService.saveOrUpdateGuest(guest);
        return guest;
    }
}
