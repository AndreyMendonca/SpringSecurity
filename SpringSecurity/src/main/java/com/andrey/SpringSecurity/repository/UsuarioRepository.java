package com.andrey.SpringSecurity.repository;

import com.andrey.SpringSecurity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByLogin(String login);
}
