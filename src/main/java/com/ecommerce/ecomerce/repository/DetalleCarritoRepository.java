package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Integer> {
    // Métodos personalizados, si son necesarios
}
