package com.andrey.SpringSecurity.controller;

import com.andrey.SpringSecurity.model.Usuario;
import com.andrey.SpringSecurity.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Usuario usuario){
        service.salvar(usuario);
    }
}
