package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Producto;
import com.ecommerce.ecomerce.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> getProductoById(int id) {
        return productoRepository.findById(id);
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}
