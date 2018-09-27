package seba0.javaszc4.hotel.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import seba0.javaszc4.hotel.server.model.entity.Reservation;
import seba0.javaszc4.hotel.server.model.entity.Room;
import seba0.javaszc4.hotel.server.service.ReservationService;
import seba0.javaszc4.hotel.server.service.RoomService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Room> list() {
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/{nr}", method = RequestMethod.GET)
    @ResponseBody
    public Room getByNr(@PathVariable("nr") short nr) {
        Optional<Room> room = roomService.getRoomByNr(nr);
        return room.orElse(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Room add(@RequestBody Room room) {
        roomService.saveOrUpdateRoom(room);
        return room;
    }

    @RequestMapping(value = "/list/free/{fromDate}/{toDate}", method = RequestMethod.GET)
    @ResponseBody
    public List<Room> listFree(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("fromDate") Date fromDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("toDate") Date toDate) {
        List<Room> freeRooms = new ArrayList<>();
        List<Room> allRooms = roomService.getAllRooms();
        for (Room room : allRooms) {
            if (isRoomFree(fromDate, toDate, room)) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    private boolean isRoomFree(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate, Room room) {
        List<Reservation> reservationByRoom = reservationService.getReservationByRoom(room);
        for (Reservation reservation : reservationByRoom) {
            Date dateTo = reservation.getDateTo();
            Date dateFrom = reservation.getDateFrom();
            if (!dateTo.before(fromDate) && !dateFrom.after(toDate)) {
                return false;
            }
        }
        return true;
    }


}
