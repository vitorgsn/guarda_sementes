package br.com.ifs.edu.guarda_sementes.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifs.edu.guarda_sementes.dtos.user.CreateUserDTO;
import br.com.ifs.edu.guarda_sementes.dtos.user.ResponseUserDTO;
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
@RequestMapping("/users")
@Tag(name = "Users", description = "Operações relacionadas a usuários")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ResponseUserDTO> list() {
        return this.userService.list().stream().map(ResponseUserDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseUserDTO findById(@PathVariable @NotNull @Valid UUID id) {
        return new ResponseUserDTO(this.userService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserModel update(@PathVariable UUID id, @RequestBody UserModel userModel) {
        return this.userService.update(id, userModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void delete(@PathVariable UUID id) {
        this.userService.delete(id);
    }

}