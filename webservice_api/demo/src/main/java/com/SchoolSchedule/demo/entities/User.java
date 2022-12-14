package com.SchoolSchedule.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String funcao;
	private Integer registroEscolar;
	private String email;
	private String senha;
	@JsonFormat(pattern="dd/MM/yyyy'T'HH:mm:ss")
	private Date cadastro;
	
	@OneToMany(mappedBy = "user")
	public List<Agendamento> agendamentos = new ArrayList<>();
	
	public User() {
		
	}
	
	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String nome, String funcao, Integer registroEscolar,String email,String senha,Date cadastro) {
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.registroEscolar = registroEscolar;
		this.email=email;
		this.senha=senha;
		this.cadastro = cadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getRegistroEscolar() {
		return registroEscolar;
	}

	public void setRegistroEscolar(Integer registroEscolar) {
		this.registroEscolar = registroEscolar;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
