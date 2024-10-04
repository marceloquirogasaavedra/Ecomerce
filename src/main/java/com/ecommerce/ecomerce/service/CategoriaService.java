package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Categoria;
import com.ecommerce.ecomerce.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> getCategoriaById(int id) {
        return categoriaRepository.findById(id);
    }

    public void deleteCategoria(int id) {
        categoriaRepository.deleteById(id);
    }
}
