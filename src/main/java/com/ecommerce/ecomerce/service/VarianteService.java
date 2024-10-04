package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Variante;
import com.ecommerce.ecomerce.repository.VarianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VarianteService {

    private final VarianteRepository varianteRepository;

    public List<Variante> getAllVariantes() {
        return varianteRepository.findAll();
    }

    public Variante saveVariante(Variante variante) {
        return varianteRepository.save(variante);
    }

    public Optional<Variante> getVarianteById(int id) {
        return varianteRepository.findById(id);
    }

    public void deleteVariante(int id) {
        varianteRepository.deleteById(id);
    }
}
