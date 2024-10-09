package com.alexsandro.Reserva.de.Salas.controller;

import com.alexsandro.Reserva.de.Salas.domain.usuarios.Users;
import com.alexsandro.Reserva.de.Salas.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers (){
        List<Users> users = usersService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity createUsers (@RequestBody Users users){
        Users newUsers = usersService.createUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUsers);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsers (@PathVariable int id, @RequestBody Users users){
        Users updateUsers = usersService.updateUsers(id, users);
        return ResponseEntity.ok(updateUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUSers (@PathVariable int id){
        Users deleteUser = usersService.deleteUsers(id);
        return ResponseEntity.ok(deleteUser);
    }
}
