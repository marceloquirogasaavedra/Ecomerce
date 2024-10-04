package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    // Métodos personalizados, si son necesarios
}
