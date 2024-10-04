package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Venta;
import com.ecommerce.ecomerce.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;

    // Obtener todas las ventas
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    // Guardar una nueva venta
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Obtener una venta por ID
    public Optional<Venta> getVentaById(int id) {
        return ventaRepository.findById(id);
    }

    // Eliminar una venta por ID
    public void deleteVenta(int id) {
        ventaRepository.deleteById(id);
    }
}
