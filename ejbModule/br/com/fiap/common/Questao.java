package br.com.fiap.common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "questao")
@XmlRootElement
public class Questao implements Serializable {

	private static final long serialVersionUID = -3694111958200232234L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)																																			//@Column(name="codigo")
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "codigoavaliacao")
	private Integer codigoAvaliacao;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "questao")
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
		return codigo;
	}

	public void setId(Integer id) {
		this.codigo = id;
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
