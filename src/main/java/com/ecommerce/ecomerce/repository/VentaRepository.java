package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

}
