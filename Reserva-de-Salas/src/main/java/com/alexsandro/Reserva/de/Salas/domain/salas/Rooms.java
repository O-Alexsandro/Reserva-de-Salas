package com.alexsandro.Reserva.de.Salas.domain.salas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "rooms")
@Entity(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int capacity;

    private String location;

    private boolean available;

}
