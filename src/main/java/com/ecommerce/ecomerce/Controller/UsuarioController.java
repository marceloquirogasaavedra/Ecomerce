package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.DTO.UsuarioDTO;
import com.ecommerce.ecomerce.model.Rol;
import com.ecommerce.ecomerce.model.Usuarios;
import com.ecommerce.ecomerce.service.RolService;
import com.ecommerce.ecomerce.service.UsuarioService;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping ("/listar")
    public ResponseEntity<List<Usuarios>> read() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping(path = "/guardar")
    public ResponseEntity<Usuarios> crear(@RequestBody UsuarioDTO c){

        try {
            Rol rol = rolService.findById(c.getId_rol()).orElseThrow(() -> new Exception("Rol no encontrado"));

            Usuarios nuevoUsuario = new Usuarios();
            nuevoUsuario.setCorreo(c.getCorreo());
            nuevoUsuario.setUsername(c.getUsername());
            nuevoUsuario.setPassword(passwordEncoder.encode(c.getPassword()));
            nuevoUsuario.setId_rol(rol);  // Asigna el rol encontrado

            Usuarios nuevo = usuarioService.save(nuevoUsuario);
            return ResponseEntity.created(new URI("/aulas/crear/" + nuevo.getId())).body(nuevo);


        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
