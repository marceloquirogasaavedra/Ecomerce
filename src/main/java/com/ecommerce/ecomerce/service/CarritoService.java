package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Carrito;
import com.ecommerce.ecomerce.repository.CarritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarritoService {

    private final CarritoRepository carritoRepository;

    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    public Carrito saveCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Optional<Carrito> getCarritoById(int id) {
        return carritoRepository.findById(id);
    }

    public void deleteCarrito(int id) {
        carritoRepository.deleteById(id);
    }
}
