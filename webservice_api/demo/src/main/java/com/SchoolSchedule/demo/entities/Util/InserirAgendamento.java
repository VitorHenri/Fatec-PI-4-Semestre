package com.SchoolSchedule.demo.entities.Util;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InserirAgendamento {
	private Long salaID;
	private Long userID;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date inicio;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date fim;
	
	public InserirAgendamento(Long salaID, Long userID, Date inicio, Date fim) {
		this.salaID = salaID;
		this.userID = userID;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public InserirAgendamento() {
		
	}

	public Long getSalaID() {
		return salaID;
	}

	public void setSalaID(Long salaID) {
		this.salaID = salaID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	
	
}
