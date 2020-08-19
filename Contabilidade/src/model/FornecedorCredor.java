package model;

import javax.persistence.Entity;

import javax.validation.constraints.NotEmpty;

import model.validation.FornecedorCredorValidation;
import model.validation.Validation;

@Entity
public class FornecedorCredor extends DefaultEntity<FornecedorCredor>{

	@NotEmpty(message = "O campo Nome não pode ser vazio")
	private String nome;
	
	@NotEmpty(message = "O campo CPF/CNPJ não pode ser vazio")
	private String cpfCnpj;
	
	private static final long serialVersionUID = 7039546790309972247L;

	@Override
	public Validation<FornecedorCredor> getValidation() {
		return new FornecedorCredorValidation();
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
