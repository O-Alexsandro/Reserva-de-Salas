package com.alexsandro.Reserva.de.Salas.DTO;

import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import com.alexsandro.Reserva.de.Salas.domain.usuarios.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationRequest (
    int userId,
    int roomId,
    LocalDate dataReserve,
    LocalTime timeStart,
    LocalTime timeEnd,
    String status
){}
