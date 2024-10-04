package com.ecommerce.ecomerce.Security;

import com.ecommerce.ecomerce.model.Rol;
import com.ecommerce.ecomerce.model.Usuarios;
import com.ecommerce.ecomerce.service.RolService;
import com.ecommerce.ecomerce.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AdminInitializer {

    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initAdminUser() {
        return args -> {
            // Verificar si existe el rol "ADMIN"
            Rol adminRole = rolService.findAll().stream()
                    .filter(role -> "ADMIN".equals(role.getName()))
                    .findFirst()
                    .orElseGet(() -> {
                        // Si no existe, creamos el rol "ADMIN"
                        Rol newAdminRole = new Rol();
                        newAdminRole.setName("ADMIN");
                        return rolService.save(newAdminRole);
                    });

            // Verificar si ya existe un usuario administrador
            boolean adminExists = usuarioService.findAll().stream()
                    .anyMatch(user -> "admin".equals(user.getUsername()));

            if (!adminExists) {
                // Crear el usuario administrador
                Usuarios adminUser = new Usuarios();
                adminUser.setUsername("admin");
                adminUser.setCorreo("admin@ecommerce.com");
                adminUser.setPassword(passwordEncoder.encode("admin123")); // Encriptar la contraseña
                adminUser.setId_rol(adminRole);

                // Guardar el usuario en la base de datos
                usuarioService.save(adminUser);
                System.out.println("Usuario administrador creado: admin/admin123");
            } else {
                System.out.println("Usuario administrador ya existe.");
            }
        };
    }
}
