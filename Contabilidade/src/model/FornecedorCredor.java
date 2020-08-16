package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class FornecedorCredor extends DefaultEntity<FornecedorCredor>{

	private String nome;
	private String cpfCnpj;
	
	private static final long serialVersionUID = 7039546790309972247L;

	@Override
	public Validation<FornecedorCredor> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	
}
