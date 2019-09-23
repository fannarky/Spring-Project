package br.com.bandtec.AgendaDeObjetivos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.Objetivo;
import br.com.bandtec.AgendaDeObjetivos.domain.TodosObjetivos;

@RestController
public class ObjetivoController {
	private TodosObjetivos obj;
	
	@Autowired
	public ObjetivoController(TodosObjetivos to) {
		this.obj = to;
	}
	
	@PostMapping("objetivos")
	public ResponseEntity<String> inserirObjetivo(@RequestBody Objetivo obj){
		this.obj.save(obj);
		return ResponseEntity.ok("Sucesso !");
	}
	
	@GetMapping("objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> retornarObjetos(@PathVariable("data") String data){
		return this.obj.ate(LocalDate.parse(data)).size() > 0 ? 
				ResponseEntity.ok(this.obj.ate(LocalDate.parse(data))) : 
					ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("objetivos/prioridade/{prioridade}")
	public ResponseEntity<List<Objetivo>> buscaPorPrioridade(@PathVariable("prioridade") String prioridade){
		List<Objetivo> list = this.obj.searchPorPrioridade(prioridade);
		
		return list.size() > 0 ? ResponseEntity.ok(list) : ResponseEntity.noContent().build();
		
	}
}
