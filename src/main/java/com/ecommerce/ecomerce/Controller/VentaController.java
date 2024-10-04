package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.Venta;
import com.ecommerce.ecomerce.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    // Obtener todas las ventas
    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable int id) {
        Optional<Venta> venta = ventaService.getVentaById(id);
        return venta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva venta
    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.saveVenta(venta);
    }

    // Eliminar una venta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable int id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.ok().build();
    }
}
