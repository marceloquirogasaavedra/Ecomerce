package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.RolPermiso;
import com.ecommerce.ecomerce.repository.RolPermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolPermisoService {
    @Autowired
    RolPermisoRepository rolPermisoRepository;

    public List<RolPermiso> findAll() {
        return rolPermisoRepository.findAll();
    }

    public RolPermiso save(RolPermiso r) {
        return rolPermisoRepository.save(r);
    }
}
