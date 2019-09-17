package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.domain.TodosObjetivos;
import br.com.bandtec.AgendaDeObjetivos.domain.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuarios;

@RestController
public class LoginController {
	
	private TodosUsuarios obj;
	
	@Autowired
	public LoginController(TodosUsuarios to) {
		this.obj = to;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		
		if(obj.existe(credenciais.getLogin(), credenciais.getSenha()) != null)
			return ResponseEntity.ok("Sucesso");
		else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
		
	} 
	
	
	@PostMapping("cadastro")
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuarios users){
		if(obj.existe(users.getLogin(), users.getSenha()) != null) {
			return ResponseEntity.ok("Já existe um usuario com essas credenciais");
		}else {
			this.obj.save(users);
			
			if(!users.isEmpty())
				return ResponseEntity.ok("Cadastrado!");
			
			return ResponseEntity.badRequest().body("Usuario e/ou senha não informados!");			
		}
		
	}
	

	
	
}