package br.com.bandtec.AgendaDeObjetivos.domain;

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
	
	@JsonProperty
	private String login;
	
	@JsonProperty
	private String senha;

	public Usuarios() {}
	
	public Usuarios(Long id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuarios(String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	
	public boolean isEmpty() {
		return login.length() == 0|| senha.length() == 0;
	}

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}
}
