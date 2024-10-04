package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.DetalleVenta;
import com.ecommerce.ecomerce.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalleventa")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> getAllDetallesVenta() {
        return detalleVentaService.getAllDetallesVenta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> getDetalleVentaById(@PathVariable int id) {
        Optional<DetalleVenta> detalleVenta = detalleVentaService.getDetalleVentaById(id);
        return detalleVenta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetalleVenta createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.saveDetalleVenta(detalleVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable int id) {
        detalleVentaService.deleteDetalleVenta(id);
        return ResponseEntity.ok().build();
    }
}
