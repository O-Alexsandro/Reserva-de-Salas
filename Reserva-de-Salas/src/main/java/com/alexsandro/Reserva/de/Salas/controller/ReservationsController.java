package com.alexsandro.Reserva.de.Salas.controller;

import com.alexsandro.Reserva.de.Salas.DTO.ReservationRequest;
import com.alexsandro.Reserva.de.Salas.DTO.RoomAvailabilityRequest;
import com.alexsandro.Reserva.de.Salas.domain.reservas.Reservations;
import com.alexsandro.Reserva.de.Salas.repository.ReservationsRepository;
import com.alexsandro.Reserva.de.Salas.service.ReservationsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    @Autowired
    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping
    public ResponseEntity<List<Reservations>> getReservations(
            @RequestParam(required = false)LocalDate dataReserve,
            @RequestParam(required = false)Integer roomId,
            @RequestParam(required = false) Integer userId){
        List<Reservations> reservations = reservationsService.getReservation(dataReserve, roomId, userId);
        return ResponseEntity.ok(reservations);
    }

    @PostMapping
    public ResponseEntity createReservation (@RequestBody ReservationRequest request){
        Reservations newReservation = reservationsService.createReservations(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReservation (@PathVariable int id, @RequestBody ReservationRequest request){
        Reservations updateReservation = reservationsService.updateReservations(id, request);
        return ResponseEntity.ok(updateReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation (@PathVariable int id){
        Reservations deleteReservation = reservationsService.deleteReservations(id);
        return ResponseEntity.ok(deleteReservation);
    }

    @PostMapping("/check")
    public boolean isRoomAvailable (@RequestBody RoomAvailabilityRequest request){
        boolean check = reservationsService.isRoomAvailable(request.roomId(), request.dataReserve(), request.timeStart(), request.timeEnd());
        return check;
    }

}
