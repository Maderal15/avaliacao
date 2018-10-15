package br.com.fiap.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "resposta")
@XmlRootElement
public class Resposta implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 605974351745513232L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "descricao")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "codigoquestao", referencedColumnName = "codigo") //nome fisico da coluna no banco de dados
	private Questao questao;


	public String getDescricao() {
		return descricao;
	}

	@XmlTransient
	public Questao getQuestao() {
		return questao;
	}

	public void setDescricao(String string) {
		descricao = string;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



}
