package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.validation.Validation;

@Entity
public class Organizacao extends DefaultEntity<Organizacao> {

	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcidade")
	private Cidade cidade;
	
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
