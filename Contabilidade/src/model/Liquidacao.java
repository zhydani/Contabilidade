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
public class Liquidacao extends DefaultEntity<Liquidacao> {

	private String numero;
	
	private Double valor;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;

	@ManyToOne()
	@JoinColumn(name = "idempenho", nullable = true)
	private Empenho empenho;

	private static final long serialVersionUID = 7944622261214801655L;

	@Override
	public Validation<Liquidacao> getValidation() {
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

	public Empenho getEmpenho() {
		return empenho;
	}

	public void setEmpenho(Empenho empenho) {
		this.empenho = empenho;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
