package com.ecommerce.ecomerce.Security;

import com.ecommerce.ecomerce.Security.filter.JwtAuthenticationFilter;
import com.ecommerce.ecomerce.Security.filter.JwtAuthoritationFilter;
import com.ecommerce.ecomerce.Security.jwt.JwtUtils;
import com.ecommerce.ecomerce.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SuppressWarnings("removal")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtAuthoritationFilter jwtAuthoritationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception{
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);

        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return httpSecurity
                .csrf(config-> config.disable())

                .authorizeHttpRequests( auth->{
                    auth.requestMatchers("/rol/*").permitAll();
                    auth.requestMatchers("/permiso/*").permitAll();
                    auth.requestMatchers("/rol_permiso/*").permitAll();
                    auth.requestMatchers("/usuario/*").permitAll();
                    auth.requestMatchers("/producto").permitAll();
                    auth.requestMatchers("/carrito").permitAll();
                    auth.requestMatchers("/categoria").permitAll();
                    auth.requestMatchers("/cliente").permitAll();
                    auth.requestMatchers("/descuento").permitAll();
                    auth.requestMatchers("/detallecarrito").permitAll();
                    auth.requestMatchers("/detallepedido").permitAll();
                    auth.requestMatchers("/detalleventa").permitAll();
                    auth.requestMatchers("/empleado").permitAll();
                    auth.requestMatchers("/inventario").permitAll();
                    auth.requestMatchers("/metodopago").permitAll();
                    auth.requestMatchers("/pedido").permitAll();
                    auth.requestMatchers("/producto").permitAll();
                    auth.requestMatchers("/sucursal").permitAll();
                    auth.requestMatchers("/variante").permitAll();
                    auth.requestMatchers("/venta").permitAll();

                    auth.requestMatchers("/login").permitAll();
                    //auth.anyRequest().permitAll();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session->{
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthoritationFilter, UsernamePasswordAuthenticationFilter.class)
                .cors()
                .and()
                .build();


    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager (HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and().build();
    }

}
