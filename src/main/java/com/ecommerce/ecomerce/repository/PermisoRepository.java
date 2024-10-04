package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso,Long> {
}
