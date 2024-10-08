package com.alexsandro.Reserva.de.Salas.service;

import com.alexsandro.Reserva.de.Salas.domain.usuarios.Users;
import com.alexsandro.Reserva.de.Salas.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers (){
        return usersRepository.findAll();
    }

    public Users createUsers (Users users){
        return usersRepository.save(users);
    }

    public Users updateUsers (int id, Users usersDetails){
        Users users1 = usersRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found with id " + id));
        users1.setName(usersDetails.getName());
        users1.setEmail(usersDetails.getEmail());
        users1.setPassword(usersDetails.getPassword());
        users1.setRole(usersDetails.getRole());

        return usersRepository.save(users1);
    }

    public Users deleteUsers (int id){
        Optional<Users> users = usersRepository.findById(id);
        if (users.isPresent()){
            usersRepository.delete(users.get());
            return users.get();
        } else {
            throw new NoSuchElementException("Room not found with id " + id);
        }
    }
}
