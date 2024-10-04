package com.ecommerce.ecomerce.repository;

import com.ecommerce.ecomerce.model.Cliente;
import com.ecommerce.ecomerce.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer>  {
    // Métodos personalizados, si son necesarios

}
