package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Usuarios;
import com.ecommerce.ecomerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuarios save (Usuarios c){
        return usuarioRepository.save(c);
    }
}
