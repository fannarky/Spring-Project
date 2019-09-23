package br.com.bandtec.AgendaDeObjetivos.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="usuarios")
public class Usuarios {

	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private Credenciais credenciais; 
	
	//@JsonProperty
	//private String login;
	
	//@JsonProperty
	//private String senha;

	public Usuarios() {}
	
	public Usuarios(Long id, String login, String senha) {
		super();
		this.id = id;
	}
	
	public Usuarios(String login, String senha) {
		super();
		this.id = id;
	}
	
	
	public boolean isEmpty() {
		return credenciais.getLogin().length() == 0|| credenciais.getSenha().length() == 0;
	}

	public Credenciais getCredenciais() {
		return this.credenciais;
	}
}
