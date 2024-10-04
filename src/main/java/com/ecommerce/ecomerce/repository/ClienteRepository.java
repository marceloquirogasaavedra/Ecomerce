package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Métodos personalizados, si son necesarios
}
