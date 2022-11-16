package com.SchoolSchedule.demo.repository;

import org.springframework.stereotype.Repository;

import com.SchoolSchedule.demo.entities.Agendamento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class AgendamentoCustomRepository {
	private final EntityManager em;
	
	public AgendamentoCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Agendamento> findByUserAndClass(Long idUser,Long idClass){
		Query q = em.createQuery("select A from Agendamento as A where A.sala=:salaID AND A.user=:userID",Agendamento.class);
		q.setParameter("salaID", idClass);
		q.setParameter("userID", idUser);
		return q.getResultList();
	}
}