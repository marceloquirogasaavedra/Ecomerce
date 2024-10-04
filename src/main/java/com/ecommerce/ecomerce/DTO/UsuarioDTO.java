package com.ecommerce.ecomerce.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {

    private  String correo;
    private  String username;
    private String password;
    private Long id_rol;
}
