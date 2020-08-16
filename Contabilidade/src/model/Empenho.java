package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.Validation;

@Entity
public class Empenho extends DefaultEntity<Empenho> {

	private Double valor;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Column(length = 500, nullable = false)
	private String produtoServico;
	
	@ManyToOne()
	@JoinColumn(name = "idclassificacaoorcamentaria", nullable = true)
	private ClassificacaoOrcamentaria classificacaoOrcamentaria;
	
	@ManyToOne()
	@JoinColumn(name = "idorganizacao", nullable = true)
	private Organizacao organizacao;
	
	@ManyToOne()
	@JoinColumn(name = "idfornecedorcredor", nullable = true)
	private FornecedorCredor fornecedorCredor;
	
	private static final long serialVersionUID = -1366382983361538372L;

	@Override
	public Validation<Empenho> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getProdutoServico() {
		return produtoServico;
	}

	public void setProdutoServico(String produtoServico) {
		this.produtoServico = produtoServico;
	}

	public ClassificacaoOrcamentaria getClassificacaoOrcamentaria() {
		return classificacaoOrcamentaria;
	}

	public void setClassificacaoOrcamentaria(ClassificacaoOrcamentaria classificacaoOrcamentaria) {
		this.classificacaoOrcamentaria = classificacaoOrcamentaria;
	}

	public Organizacao getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(Organizacao organizacao) {
		this.organizacao = organizacao;
	}

	public FornecedorCredor getFornecedorCredor() {
		return fornecedorCredor;
	}

	public void setFornecedorCredor(FornecedorCredor fornecedorCredor) {
		this.fornecedorCredor = fornecedorCredor;
	}
	
	

}
