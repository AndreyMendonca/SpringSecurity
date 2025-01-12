package com.andrey.SpringSecurity.repository;

import com.andrey.SpringSecurity.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
