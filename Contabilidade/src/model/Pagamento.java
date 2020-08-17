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
public class Pagamento extends DefaultEntity<Pagamento> {

	private String numero;
	
	private Double valor;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;

	@ManyToOne()
	@JoinColumn(name = "idliquidacao", nullable = true)
	private Liquidacao liquidacao;

	private static final long serialVersionUID = 645702574565914835L;

	@Override
	public Validation<Pagamento> getValidation() {
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

	public Liquidacao getLiquidacao() {
		return liquidacao;
	}

	public void setLiquidacao(Liquidacao liquidacao) {
		this.liquidacao = liquidacao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
