package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Variante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteRepository extends JpaRepository<Variante, Integer> {
    // Métodos personalizados, si son necesarios
}
