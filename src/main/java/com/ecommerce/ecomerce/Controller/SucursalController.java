package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.Sucursal;
import com.ecommerce.ecomerce.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> getAllSucursales() {
        return sucursalService.getAllSucursales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable int id) {
        Optional<Sucursal> sucursal = sucursalService.getSucursalById(id);
        return sucursal.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sucursal createSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.saveSucursal(sucursal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable int id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.ok().build();
    }
}
