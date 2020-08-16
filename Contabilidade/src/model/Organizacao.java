package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Organizacao extends DefaultEntity<Organizacao> {

	private String nome;
	
	
	
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

	

}
