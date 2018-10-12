package br.com.fiap.testes;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.Avaliacao;
import br.com.fiap.common.Questao;
import br.com.fiap.common.Resposta;

public class TesteBanco {

	public static void main(String[] args) {
		Context context;
		try {
			context = new InitialContext();

			Avaliacao avaliacao = (Avaliacao) context.lookup("QuestaoBean/remote");

			
			
			List<Questao> lista =  avaliacao.obterQuestoes(1);
			List<Resposta> lista2 = avaliacao.obterResposta();
			
			for (Resposta resposta : lista2) {
				System.out.println(resposta.getDescricao());
			}
			
			
			for (Questao questao2 : lista) {
				System.out.println(questao2.getDescricao());
			}
			
						
			//System.out.println("Quantidade de chamados abertos: " + questaoRemote.recuperarTodos().size());

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
