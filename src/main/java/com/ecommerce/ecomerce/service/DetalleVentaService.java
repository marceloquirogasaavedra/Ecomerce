package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.DetalleVenta;
import com.ecommerce.ecomerce.repository.DetalleVentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> getAllDetallesVenta() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public Optional<DetalleVenta> getDetalleVentaById(int id) {
        return detalleVentaRepository.findById(id);
    }

    public void deleteDetalleVenta(int id) {
        detalleVentaRepository.deleteById(id);
    }
}
