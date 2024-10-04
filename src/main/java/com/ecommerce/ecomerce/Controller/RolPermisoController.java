package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.DTO.RolPermisoDTO;
import com.ecommerce.ecomerce.model.Permiso;
import com.ecommerce.ecomerce.model.Rol;
import com.ecommerce.ecomerce.model.RolPermiso;
import com.ecommerce.ecomerce.service.PermisoService;
import com.ecommerce.ecomerce.service.RolPermisoService;
import com.ecommerce.ecomerce.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rol_permiso")
public class RolPermisoController {
    @Autowired
    RolPermisoService rolPermisoService;
    @Autowired
    PermisoService permisoService;
    @Autowired
    RolService rolService;

    @GetMapping("/listar")
    public ResponseEntity<List<RolPermiso>> read() {
        return ResponseEntity.ok(rolPermisoService.findAll());
    }


    @PostMapping(path = "/guardar")
    public ResponseEntity<RolPermiso> crear(@RequestBody RolPermisoDTO r){

        try {
            Permiso permiso = permisoService.findById(r.getId_permiso()).orElseThrow(() -> new Exception("no encontrado"));
            Rol id_rol = rolService.findById(r.getId_rol()).orElseThrow(() -> new Exception("no encontrado"));

            RolPermiso rolPermiso = new RolPermiso();
            rolPermiso.setId_permiso(permiso);
            rolPermiso.setId_rol(id_rol);

            RolPermiso nuevo = rolPermisoService.save(rolPermiso);
            return ResponseEntity.created(new URI("/rol_permiso/guardar/"+nuevo.getId())).body(nuevo);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}