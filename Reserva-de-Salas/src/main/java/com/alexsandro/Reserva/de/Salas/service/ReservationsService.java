package com.alexsandro.Reserva.de.Salas.service;

import com.alexsandro.Reserva.de.Salas.DTO.ReservationRequest;
import com.alexsandro.Reserva.de.Salas.domain.reservas.Reservations;
import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import com.alexsandro.Reserva.de.Salas.domain.usuarios.Users;
import com.alexsandro.Reserva.de.Salas.repository.ReservationsRepository;
import com.alexsandro.Reserva.de.Salas.repository.RoomsRepository;
import com.alexsandro.Reserva.de.Salas.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    private final UsersRepository usersRepository;

    private final RoomsRepository roomsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository, UsersRepository usersRepository, RoomsRepository roomsRepository) {
        this.reservationsRepository = reservationsRepository;
        this.usersRepository = usersRepository;
        this.roomsRepository = roomsRepository;
    }

    public List<Reservations> getReservation (){
        return reservationsRepository.findAll();
    }

    public Reservations createReservations (ReservationRequest request) {
        Users user = usersRepository.findById(request.userId()).orElseThrow(() -> new NoSuchElementException("User not found with id " + request.userId()));
        Rooms rooms = roomsRepository.findById(request.roomId()).orElseThrow(() -> new NoSuchElementException("Room not found with id " + request.userId()));

        Reservations newReservation = new Reservations();
        newReservation.setUsers(user);
        newReservation.setRooms(rooms);
        newReservation.setDataReserve(request.dataReserve());
        newReservation.setTimeStart(request.timeStart());
        newReservation.setTimeEnd(request.timeEnd());
        newReservation.setStatus(request.status());

        System.out.println("Data Reserve: " + request.dataReserve());  // Log para verificar o valor

        return reservationsRepository.save(newReservation);
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
