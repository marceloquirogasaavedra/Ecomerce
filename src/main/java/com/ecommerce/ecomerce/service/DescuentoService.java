package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Descuento;
import com.ecommerce.ecomerce.repository.DescuentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DescuentoService {

    private final DescuentoRepository descuentoRepository;

    public List<Descuento> getAllDescuentos() {
        return descuentoRepository.findAll();
    }

    public Descuento saveDescuento(Descuento descuento) {
        return descuentoRepository.save(descuento);
    }

    public Optional<Descuento> getDescuentoById(int id) {
        return descuentoRepository.findById(id);
    }

    public void deleteDescuento(int id) {
        descuentoRepository.deleteById(id);
    }
}
