package com.alexsandro.Reserva.de.Salas.controller;

import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import com.alexsandro.Reserva.de.Salas.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private final RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping
    public ResponseEntity<List<Rooms>> getRooms (){
        List<Rooms> rooms = roomsService.getRooms();
        return ResponseEntity.ok(rooms);
    }

    @PostMapping
    public ResponseEntity createRooms (@RequestBody Rooms rooms){
        Rooms newRooms = roomsService.createRooms(rooms);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRooms);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRooms (@PathVariable int id, @RequestBody Rooms rooms){
        Rooms updateRooms = roomsService.updateRooms(id, rooms);
        return ResponseEntity.ok(updateRooms);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteRooms (@PathVariable int id){
        Rooms deleteRooms = roomsService.delete(id);
        return ResponseEntity.ok(deleteRooms);
    }
}
