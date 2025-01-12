package com.andrey.SpringSecurity.controller;

import com.andrey.SpringSecurity.model.Produto;
import com.andrey.SpringSecurity.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void salvar(@RequestBody Produto produto){
        service.salvar(produto);
    }
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Produto> findAll(){
        return service.findAll();
    }
}
