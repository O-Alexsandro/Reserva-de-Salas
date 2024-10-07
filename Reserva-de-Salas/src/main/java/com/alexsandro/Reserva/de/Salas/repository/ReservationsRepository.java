package com.alexsandro.Reserva.de.Salas.repository;

import com.alexsandro.Reserva.de.Salas.domain.reservas.Reservations;
import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository <Reservations, Integer> {
}
