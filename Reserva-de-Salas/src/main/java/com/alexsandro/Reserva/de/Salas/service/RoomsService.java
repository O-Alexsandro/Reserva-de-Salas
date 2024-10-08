package com.alexsandro.Reserva.de.Salas.service;

import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import com.alexsandro.Reserva.de.Salas.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoomsService {

    private final RoomsRepository roomsRepository;

    @Autowired
    public RoomsService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public List<Rooms> getRooms(){
        return roomsRepository.findAll();
    }

    public Rooms createRooms (Rooms rooms){
        return roomsRepository.save(rooms);
    }

    public Rooms updateRooms(int id, Rooms roomDetails){
        Rooms room = roomsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found with id " + id));
        room.setName(roomDetails.getName());
        room.setCapacity(room.getCapacity());
        room.setLocation(roomDetails.getLocation());
        room.setAvailable(roomDetails.isAvailable());

        return roomsRepository.save(room);
    }

    public Rooms delete (int id){
        Optional<Rooms> room = roomsRepository.findById(id);
        if (room.isPresent()){
            roomsRepository.delete(room.get());
            return room.get();
        } else {
            throw new NoSuchElementException("Room not found with id " + id);
        }
    }
}
