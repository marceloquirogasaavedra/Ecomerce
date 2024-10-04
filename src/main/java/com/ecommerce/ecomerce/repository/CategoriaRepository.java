package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Métodos personalizados, si son necesarios


}
