package com.flashcard.flashcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlashcardsApplication {

	//usar puerto 8082
	public static void main(String[] args) {
		SpringApplication.run(FlashcardsApplication.class, args);
	}

	// Permite ejecutar código con interfaz funcional
	// Se ejecuta después de que se haya creado el contexto de app y antes de que se ejecute la app principal
	// Es como un import.sql
	@Bean
	CommandLineRunner commandLineRunner(UsuarioRepository usuarios, PasswordEncoder encoder) {
		return args -> {

			usuarios.save(new Usuario("user", encoder.encode("password"), "ROLE_USER"));
			usuarios.save(new Usuario("admin", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));

		};
	}
}
