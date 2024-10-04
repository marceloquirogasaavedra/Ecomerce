package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Rol;
import com.ecommerce.ecomerce.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;



    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol save (Rol c){
        return rolRepository.save(c);
    }

    public Optional<Rol> findById(Long idRol) {
        return rolRepository.findById(idRol);
    }
}
