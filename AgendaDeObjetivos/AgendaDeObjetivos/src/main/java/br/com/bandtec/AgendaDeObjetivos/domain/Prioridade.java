package br.com.bandtec.AgendaDeObjetivos.domain;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Prioridade {
	
	@JsonProperty
	private String nome;
	
	@JsonProperty
	private String observacoes;
	
	protected Prioridade() {}

	public Prioridade(String nome, String observacoes) {
		super();
		this.nome = nome;
		this.observacoes = observacoes;
	}

	public String getNome() {
		return nome;
	}

	public String getObservacoes() {
		return observacoes;
	}

}