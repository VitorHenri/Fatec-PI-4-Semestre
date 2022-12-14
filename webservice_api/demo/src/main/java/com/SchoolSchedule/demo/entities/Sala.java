package com.SchoolSchedule.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.SchoolSchedule.demo.entities.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tb_sala")
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private char bloco;
	private Integer numero;
	private Integer tipo;
	private String descricao;
	private Boolean ativo;
	
	@OneToMany(mappedBy = "sala")
	public List<Agendamento> agendamentos = new ArrayList<>();
	
	public Sala() {
		
	}
	
	public Sala(Long id) {
		this.id = id;
	}

	public Sala(Long id, char bloco,Integer numero, Integer tipoCodigo, String descricao, Boolean ativo) {
		this.id = id;
		this.bloco = bloco;
		this.numero = numero;
		this.tipo = tipoCodigo;
		this.descricao = descricao;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getBloco() {
		return bloco;
	}

	public void setBloco(char bloco) {
		this.bloco = bloco;
	}
	

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return Tipo.valueOf(tipo);
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo.getCodigo();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@JsonIgnore
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
}
