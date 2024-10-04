package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.MetodoPago;
import com.ecommerce.ecomerce.service.MetodoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodopago")
@RequiredArgsConstructor
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPago> getAllMetodosPago() {
        return metodoPagoService.getAllMetodosPago();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getMetodoPagoById(@PathVariable int id) {
        Optional<MetodoPago> metodoPago = metodoPagoService.getMetodoPagoById(id);
        return metodoPago.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MetodoPago createMetodoPago(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.saveMetodoPago(metodoPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable int id) {
        metodoPagoService.deleteMetodoPago(id);
        return ResponseEntity.ok().build();
    }
}
