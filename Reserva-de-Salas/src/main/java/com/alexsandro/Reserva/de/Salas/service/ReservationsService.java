package com.alexsandro.Reserva.de.Salas.service;

import com.alexsandro.Reserva.de.Salas.domain.reservas.Reservations;
import com.alexsandro.Reserva.de.Salas.repository.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public List<Reservations> getReservation (){
        return reservationsRepository.findAll();
    }

    public Reservations createReservations (Reservations reservations) {
        return reservationsRepository.save(reservations);
    }

    public Reservations updateReservations (int id, Reservations reservations){
        Reservations reservations1 = reservationsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found with id " + id));

        reservations1.setDataReserve(reservations.getDataReserve());
        reservations1.setTimeStart(reservations.getTimeStart());
        reservations1.setTimeEnd(reservations.getTimeEnd());
        reservations1.setRooms(reservations.getRooms());
        reservations1.setStatus(reservations.getStatus());
        reservations1.setUsers(reservations.getUsers());

        return reservationsRepository.save(reservations1);
    }

    public Reservations deleteReservations (int id){
        Optional<Reservations> optionalReservations = reservationsRepository.findById(id);
        if (optionalReservations.isPresent()){
            reservationsRepository.delete(optionalReservations.get());
            return optionalReservations.get();
        } else {
            throw new NoSuchElementException("Room not found with id " + id);
        }
    }
}
