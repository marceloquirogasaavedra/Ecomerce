package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Integer> {
    // Métodos personalizados, si son necesarios
}
