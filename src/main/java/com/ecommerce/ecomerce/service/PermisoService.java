package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Permiso;
import com.ecommerce.ecomerce.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {
    @Autowired
    PermisoRepository permisoRepository;


    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    public Permiso save(Permiso p) {
        return permisoRepository.save(p);
    }

    public Optional<Permiso> findById(Long idPermiso) {
        return permisoRepository.findById(idPermiso);
    }
}
