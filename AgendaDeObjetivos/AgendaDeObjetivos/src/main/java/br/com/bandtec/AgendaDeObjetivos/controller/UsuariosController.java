package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;

@RestController()
public class UsuariosController {

	private List<Usuario> usuarios;
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/nome/{nome}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nome") String nome){
		List<Usuario> users = new ArrayList<>();
		for(Usuario user : this.usuarios) {
			
			if(user.getNome().equals(nome))
				users.add(user);
		
		}
		
		if(!users.isEmpty())
			return ResponseEntity.ok(users);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/usuarios/idade/{idade}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idade") Integer idade){
		List<Usuario> usersPorIdade = new ArrayList<>();
		
		for(Usuario userid : this.usuarios) {
			if(userid.getIdade() == idade)
				usersPorIdade.add(userid);
		}
		if(!usersPorIdade.isEmpty())
			return ResponseEntity.ok(usersPorIdade);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		return ResponseEntity.ok(obterTodosUsuarios());
	}
	
	private List<Usuario> obterTodosUsuarios(){
		/*return Arrays.asList(
				new Usuario("Rodrigo", 39),
				new Usuario("Joao", 22),
				new Usuario("Jose", 30)
			);*/
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(new Usuario("Rodrigo", 39));
		usuarios.add(new Usuario("Joao", 22));
		usuarios.add(new Usuario("Jose", 30));
		
		return usuarios;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		this.usuarios.add(usuario);
		return ResponseEntity.ok(usuario);
	}
}
