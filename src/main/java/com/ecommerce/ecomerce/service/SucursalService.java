package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Sucursal;
import com.ecommerce.ecomerce.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    public Sucursal saveSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Optional<Sucursal> getSucursalById(int id) {
        return sucursalRepository.findById(id);
    }

    public void deleteSucursal(int id) {
        sucursalRepository.deleteById(id);
    }
}

