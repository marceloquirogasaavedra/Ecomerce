package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.RolPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolPermisoRepository extends JpaRepository<RolPermiso, Long> {
}
