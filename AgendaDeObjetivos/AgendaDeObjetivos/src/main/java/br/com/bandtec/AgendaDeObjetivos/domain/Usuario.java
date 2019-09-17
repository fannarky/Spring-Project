package br.com.bandtec.AgendaDeObjetivos.domain;

public class Usuario {

	private String nome;
	private Integer idade;

	public Usuario(String string, int i) {
		this.nome = string;
		this.idade = i;
	}

	public String getNome() {
		return this.nome;
	}

	public Integer getIdade() {
		return this.idade;
	}

}
