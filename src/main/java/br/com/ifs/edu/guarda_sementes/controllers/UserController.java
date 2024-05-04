package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.models.UserModel;
import br.com.ifs.edu.guarda_sementes.services.UserService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.create(userModel));
    }

}