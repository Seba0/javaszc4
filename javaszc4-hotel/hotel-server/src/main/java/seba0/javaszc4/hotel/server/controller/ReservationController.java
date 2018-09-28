package seba0.javaszc4.hotel.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.hotel.server.model.entity.Reservation;
import seba0.javaszc4.hotel.server.service.ReservationService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Reservation> list() {
        return reservationService.getAllReservations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Reservation getById(@PathVariable("id") long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.orElse(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Reservation add(@RequestBody Reservation reservation) {
        reservation.setDate(new Date());
        reservationService.saveOrUpdateReservation(reservation);
        return reservation;
    }
}
