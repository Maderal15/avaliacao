package br.com.fiap.common;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.Avaliacao;

@Stateless
@Remote(Avaliacao.class)
@WebService(name="Avaliacao")
public class AvaliacaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7537936661712297889L;
	@PersistenceContext(name="prova")
	private EntityManager em;

	public List<Questao> obterQuestoes(@WebParam(name="codigoAvaliacao") int codigoAvaliacao) {
		 
		TypedQuery<Questao> query = em.createQuery("select distinct q from Questao q left join FETCH q.respostas where q.codigoAvaliacao=:codigoAvaliacao", Questao.class);
		query.setParameter("codigoAvaliacao", codigoAvaliacao);
		 
		return query.getResultList();

	}

	@Remove
	 public void removerEJB() {
		System.out.println("Removendo instancia EJB ChamadoBean.");
	}
}
