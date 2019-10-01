package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;

@RestController()
public class UsuariosController {

	private TodosUsuarios tusuarios;
	
	
	@Autowired
	public UsuariosController(TodosUsuarios u) {
		tusuarios = u;
	}
	
	@GetMapping("/usuarios/nome/{nome}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nome") String nome){
		
		List<Usuario> usuarios = tusuarios.findByName(nome);
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build(); 
		}
		
		return ResponseEntity.ok(usuarios);
		
	}
	
	@GetMapping("/usuarios/idade/{idade}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idade") Integer idade){
		
		List<Usuario> l = tusuarios.findByAge(idade);
		if(!l.isEmpty())
			return ResponseEntity.ok(l);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		return ResponseEntity.ok(obterTodosUsuarios());
	}
	
	private List<Usuario> obterTodosUsuarios(){
		return tusuarios.findAll();
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario u = this.tusuarios.save(usuario);
		if(u.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(usuario);
	}
}
