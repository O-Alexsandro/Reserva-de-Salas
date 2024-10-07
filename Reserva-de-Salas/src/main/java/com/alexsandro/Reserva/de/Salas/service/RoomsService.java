package com.alexsandro.Reserva.de.Salas.service;

import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import com.alexsandro.Reserva.de.Salas.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
