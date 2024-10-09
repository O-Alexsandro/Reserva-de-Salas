package com.alexsandro.Reserva.de.Salas.controller;

import com.alexsandro.Reserva.de.Salas.domain.reservas.Reservations;
import com.alexsandro.Reserva.de.Salas.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Reservations>> getReservations(){
        List<Reservations> reservations = reservationsService.getReservation();
        return ResponseEntity.ok(reservations);
    }

    @PostMapping
    public ResponseEntity createReservation (@RequestBody Reservations reservations){
        Reservations newReservation = reservationsService.createReservations(reservations);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReservation (@PathVariable int id, @RequestBody Reservations reservations){
        Reservations updateReservation = reservationsService.updateReservations(id, reservations);
        return ResponseEntity.ok(updateReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation (@PathVariable int id){
        Reservations deleteReservation = reservationsService.deleteReservations(id);
        return ResponseEntity.ok(deleteReservation);
    }
}
