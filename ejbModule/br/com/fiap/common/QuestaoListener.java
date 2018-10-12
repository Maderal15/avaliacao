package br.com.fiap.common;

import javax.persistence.PrePersist;

public class QuestaoListener {
	
	@PrePersist
	public void preInsert(Object object) {
		System.out.println("Inserindo " + object.getClass() + " no banco de dados.");
	}
}
