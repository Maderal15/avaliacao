package br.com.fiap.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "questao")
@EntityListeners(AvaliacaoListener.class)
public class Questao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)																																			//@Column(name="codigo")
	@Column(name = "codigo")
	private Integer id;
	
	@Column(name = "codigoavaliacao")
	private Integer codigoAvaliacao;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Resposta.class, mappedBy = "questao")
    private List<Resposta> respostas;
	
	@Transient
	private Resposta respostaSelecionada;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String string) {
		descricao = string;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Integer getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public void setCodigoAvaliacao(Integer codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Resposta getRespostaSelecionada() {
		return respostaSelecionada;
	}

	public void setRespostaSelecionada(Resposta respostaSelecionada) {
		this.respostaSelecionada = respostaSelecionada;
	}
	
	@PrePersist
	public void preInsert() {
		System.out.println("Inserindo chamado no banco de dados.");
	}
	
	
}
