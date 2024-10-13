package com.alexsandro.Reserva.de.Salas.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public record RoomAvailabilityRequest(
        int roomId,
        LocalDate dataReserve,
        LocalTime timeStart,
        LocalTime timeEnd
) {}
