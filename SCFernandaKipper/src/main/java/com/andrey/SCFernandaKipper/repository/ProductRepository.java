package com.andrey.SCFernandaKipper.repository;

import com.andrey.SCFernandaKipper.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
