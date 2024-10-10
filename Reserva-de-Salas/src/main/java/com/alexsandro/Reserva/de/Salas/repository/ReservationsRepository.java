package com.alexsandro.Reserva.de.Salas.repository;

import com.alexsandro.Reserva.de.Salas.domain.reservas.Reservations;
import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface ReservationsRepository extends JpaRepository <Reservations, Integer>, JpaSpecificationExecutor<Reservations> {

    List<Reservations> findByDataReserve(LocalDate dataReserve);

    List<Reservations> findByRoomsId(Integer roomId);

    List<Reservations> findByUsersId(Integer userId);

    List<Reservations> findByDataReserveAndRoomsIdAndUsersId(LocalDate dataReserve, Integer roomId, Integer userId);
    List<Reservations> findByDataReserveAndRoomsId(LocalDate dataReserve, Integer roomId);
    List<Reservations> findByDataReserveAndUsersId(LocalDate dataReserve, Integer userId);
    List<Reservations> findByRoomsIdAndUsersId(Integer roomId, Integer userId);

}
