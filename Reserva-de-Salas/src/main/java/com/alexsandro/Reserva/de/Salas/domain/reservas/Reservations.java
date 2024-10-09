package com.alexsandro.Reserva.de.Salas.domain.reservas;

import com.alexsandro.Reserva.de.Salas.DTO.ReservationRequest;
import com.alexsandro.Reserva.de.Salas.domain.salas.Rooms;
import com.alexsandro.Reserva.de.Salas.domain.usuarios.Users;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "reservations")
@Entity(name = "reservations")
@EqualsAndHashCode (of = "Id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "users_id")
    private Users users;

    @ManyToOne
    @JoinColumn (name = "rooms_id")
    private Rooms rooms;

    private LocalDate dataReserve;

    private LocalTime timeStart;

    private LocalTime timeEnd;

    private String status;

    public Reservations (ReservationRequest request){
        this.dataReserve = request.dataReserve();
        this.timeStart = request.timeStart();
        this.timeEnd = request.timeEnd();
        this.status = request.status();
    }
}
