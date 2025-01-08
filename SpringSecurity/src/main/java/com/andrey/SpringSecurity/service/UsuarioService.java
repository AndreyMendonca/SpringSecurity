package com.andrey.SpringSecurity.service;

import com.andrey.SpringSecurity.model.Usuario;
import com.andrey.SpringSecurity.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private  UsuarioRepository repository;

    @Autowired
    private  PasswordEncoder encoder;

    public void salvar(Usuario usuario){
        var senha = usuario.getSenha();
        usuario.setSenha(encoder.encode(senha));
        repository.save(usuario);
    }

    public Usuario obterPorLogin(String login){
        return repository.findByLogin(login);
    }
}
