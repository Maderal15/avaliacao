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
public class QuestaoBean implements Serializable {

	@PersistenceContext(name="prova")
	private EntityManager em;


	public List obterQuestoes(int codigoAvaliacao) {
		return em.createQuery("from Questao q where q.codigoAvaliacao=:codigoAvaliacao").setParameter("codigoAvaliacao", codigoAvaliacao).getResultList();

	}
	public List obterResposta() {
		return em.createQuery("from Resposta").getResultList();

	}

	@Remove
	 public void removerEJB() {
		System.out.println("Removendo instancia EJB ChamadoBean.");
	}
}
