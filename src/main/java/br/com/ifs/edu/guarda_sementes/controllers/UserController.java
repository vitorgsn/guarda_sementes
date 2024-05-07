package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.models.UserModel;
import br.com.ifs.edu.guarda_sementes.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserModel> list() {
        return this.userService.list();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserModel findById(@PathVariable @NotNull UUID id) {
        return this.userService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserModel create(@RequestBody @Valid UserModel userModel) {
        return this.userService.create(userModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserModel update(@PathVariable UUID id, @RequestBody UserModel userModel) {
        return this.userService.update(id, userModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        this.userService.delete(id);
    }

}