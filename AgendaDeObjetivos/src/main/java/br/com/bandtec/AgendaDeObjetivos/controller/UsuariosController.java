package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {

	private List<Usuario> usuario;
	
	public UsuariosController() {
		this.usuario = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/nome/{nome}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nome") String nome){
		List<Usuario> users = new ArrayList<>();
		for(Usuario user : this.usuario) {
			
			if(user.getNome().equals(nome))
				users.add(user);
		
		}
		
		if(!users.isEmpty())
			return ResponseEntity.ok(users);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		return ResponseEntity.ok(obterTodosUsuarios());
	}
	
	private List<Usuario> obterTodosUsuarios(){
		return Arrays.asList(
				new Usuario("Rodrigo", 39),
				new Usuario("Joao", 22),
				new Usuario("Jose", 30)
			);
	}
}
