package br.com.bandtec.AgendaDeObjetivos.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private Credenciais credenciais; 

	private String nome;
	private Integer idade;

	public Usuario() {}
	
	public Usuario(String string, int i) {
		this.nome = string;
		this.idade = i;
	}
	
	public boolean isEmpty() {
		return credenciais.getLogin().length() == 0|| credenciais.getSenha().length() == 0;
	}

	public String getNome() {
		return this.nome;
	}

	public Integer getIdade() {
		return this.idade;
	}

	public Long getId() {
		return id;
	}

	public Credenciais getCredenciais() {
		return credenciais;
	}
	
	

}
