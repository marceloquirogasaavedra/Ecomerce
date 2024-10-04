package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.MetodoPago;
import com.ecommerce.ecomerce.repository.MetodoPagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> getAllMetodosPago() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago saveMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public Optional<MetodoPago> getMetodoPagoById(int id) {
        return metodoPagoRepository.findById(id);
    }

    public void deleteMetodoPago(int id) {
        metodoPagoRepository.deleteById(id);
    }
}
