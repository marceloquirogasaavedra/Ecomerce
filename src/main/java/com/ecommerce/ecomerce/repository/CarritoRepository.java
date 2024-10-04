package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

    // Métodos personalizados, si son necesarios
    
}
