package com.flashcard.flashcards.config;

import com.flashcard.flashcards.service.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity 
@EnableMethodSecurity
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                
                .authorizeRequests(consulta -> consulta
                       
                        .mvcMatchers("/", "/index", "/registro","/mazos","/crear","/guardar","/editar/{id}","/eliminar/{id}","/tarjetas","/crearMazo","/crearTarjeta","/tarjetas/{id}","/crearTarjeta/{id}","/guardarTarjeta","/editar","/eliminar/{id}","/editarMazo","/editarTarjeta", "/js/**", "/css/**","/images/**").permitAll()
                        .anyRequest().authenticated())
               
                .userDetailsService(jpaUserDetailsService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                
                .formLogin((formulario) -> formulario
                        
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((cerrarSesion) -> cerrarSesion.permitAll())
                .build();
    }

    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
