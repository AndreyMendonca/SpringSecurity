package com.andrey.SpringSecurity.service;

import com.andrey.SpringSecurity.model.Produto;
import com.andrey.SpringSecurity.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void salvar(Produto produto){
        repository.save(produto);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }
}
