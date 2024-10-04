package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Inventario;
import com.ecommerce.ecomerce.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario saveInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Optional<Inventario> getInventarioById(int id) {
        return inventarioRepository.findById(id);
    }

    public void deleteInventario(int id) {
        inventarioRepository.deleteById(id);
    }
}
