package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.Descuento;
import com.ecommerce.ecomerce.service.DescuentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("descuento")
@RequiredArgsConstructor
public class DescuentoController {

    private final DescuentoService descuentoService;

    @GetMapping
    public List<Descuento> getAllDescuentos() {
        return descuentoService.getAllDescuentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Descuento> getDescuentoById(@PathVariable int id) {
        Optional<Descuento> descuento = descuentoService.getDescuentoById(id);
        return descuento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Descuento createDescuento(@RequestBody Descuento descuento) {
        return descuentoService.saveDescuento(descuento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDescuento(@PathVariable int id) {
        descuentoService.deleteDescuento(id);
        return ResponseEntity.ok().build();
    }
}
