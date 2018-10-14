package br.com.fiap.common;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.Avaliacao;

@Stateless
@Remote(Avaliacao.class)
public class AvaliacaoBean implements Serializable {

	@PersistenceContext(name="prova")
	private EntityManager em;


	public List obterQuestoes(int codigoAvaliacao) {
		return em.createQuery("select distinct q from Questao q inner join FETCH q.respostas where q.codigoAvaliacao=:codigoAvaliacao").setParameter("codigoAvaliacao", codigoAvaliacao).getResultList();

	}

	@Remove
	 public void removerEJB() {
		System.out.println("Removendo instancia EJB ChamadoBean.");
	}
}
