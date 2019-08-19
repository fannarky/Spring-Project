package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	private String login = "Login";
	private String senha = "Senha";
	
	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		
		if(credenciais.getSenha().equals(credenciais.getLogin()))
			return ResponseEntity.ok("Sucesso");
		else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
		
	} 
	

	
	
}