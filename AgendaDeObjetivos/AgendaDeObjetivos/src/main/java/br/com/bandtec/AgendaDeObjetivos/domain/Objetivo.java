package br.com.bandtec.AgendaDeObjetivos.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="objetivos")
public class Objetivo {

	@Id
	@GeneratedValue
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String titulo;
	
	@JsonProperty
	private String descricao;
	
	@Column(name="data_maxima_para_execucao")
	@JsonProperty
	private LocalDate dataMaximaParaExecucao;
	
	@Embedded
	@JsonProperty
	private Prioridade prioridade;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Objetivo() {}
	
	public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao, Prioridade prioridade) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

	/*
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}*/
}
