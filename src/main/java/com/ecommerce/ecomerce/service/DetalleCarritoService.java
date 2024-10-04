package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.DetalleCarrito;
import com.ecommerce.ecomerce.repository.DetalleCarritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleCarritoService {

    private final DetalleCarritoRepository detalleCarritoRepository;

    public List<DetalleCarrito> getAllDetallesCarrito() {
        return detalleCarritoRepository.findAll();
    }

    public DetalleCarrito saveDetalleCarrito(DetalleCarrito detalleCarrito) {
        return detalleCarritoRepository.save(detalleCarrito);
    }

    public Optional<DetalleCarrito> getDetalleCarritoById(int id) {
        return detalleCarritoRepository.findById(id);
    }

    public void deleteDetalleCarrito(int id) {
        detalleCarritoRepository.deleteById(id);
    }
}
