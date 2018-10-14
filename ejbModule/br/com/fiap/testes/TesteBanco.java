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

			Avaliacao avaliacao = (Avaliacao) context.lookup("AvaliacaoBean/remote");

			List<Questao> lista =  avaliacao.obterQuestoes(1);
			//2-
			for (Questao questao : lista) {
				System.out.println(questao.getDescricao());
				for (Resposta resposta : questao.getRespostas()) {
					System.out.println(resposta.getDescricao());
				}
			}
			
						
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
