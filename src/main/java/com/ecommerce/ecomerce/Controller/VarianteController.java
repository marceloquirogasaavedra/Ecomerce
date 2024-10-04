package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.Variante;
import com.ecommerce.ecomerce.service.VarianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/variante")
@RequiredArgsConstructor
public class VarianteController {

    private final VarianteService varianteService;

    @GetMapping
    public List<Variante> getAllVariantes() {
        return varianteService.getAllVariantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variante> getVarianteById(@PathVariable int id) {
        Optional<Variante> variante = varianteService.getVarianteById(id);
        return variante.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Variante createVariante(@RequestBody Variante variante) {
        return varianteService.saveVariante(variante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariante(@PathVariable int id) {
        varianteService.deleteVariante(id);
        return ResponseEntity.ok().build();
    }
}
