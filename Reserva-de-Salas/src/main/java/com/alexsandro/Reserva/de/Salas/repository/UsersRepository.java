package com.alexsandro.Reserva.de.Salas.repository;

import com.alexsandro.Reserva.de.Salas.domain.usuarios.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <Users, Integer> {
}
