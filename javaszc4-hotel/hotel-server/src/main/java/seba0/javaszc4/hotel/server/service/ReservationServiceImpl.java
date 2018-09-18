package seba0.javaszc4.hotel.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seba0.javaszc4.hotel.server.model.entity.Reservation;
import seba0.javaszc4.hotel.server.model.entity.Room;
import seba0.javaszc4.hotel.server.model.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void saveOrUpdateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> getReservationByRoom(Room room) {
        Iterable<Reservation> all = reservationRepository.findAll();
        List<Reservation> collect = StreamSupport
                .stream(all.spliterator(), false)
                .filter(room::equals)
                .collect(Collectors.toList());
        return collect;
    }
}
