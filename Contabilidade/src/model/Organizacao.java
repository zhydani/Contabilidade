package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Organizacao extends DefaultEntity<Organizacao> {

	private String nome;
	private TipoEsfera tipoEsfera;
	private TipoPoder tipoPoder;
	
	
	private static final long serialVersionUID = 1396808053486609298L;

	@Override
	public Validation<Organizacao> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoEsfera getTipoEsfera() {
		return tipoEsfera;
	}

	public void setTipoEsfera(TipoEsfera tipoEsfera) {
		this.tipoEsfera = tipoEsfera;
	}

	public TipoPoder getTipoPoder() {
		return tipoPoder;
	}

	public void setTipoPoder(TipoPoder tipoPoder) {
		this.tipoPoder = tipoPoder;
	}

	

}
