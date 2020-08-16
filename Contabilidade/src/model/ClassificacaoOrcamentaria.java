package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class ClassificacaoOrcamentaria extends DefaultEntity<ClassificacaoOrcamentaria> {
	
	private String numero;
	private String funcao;
	private String subfuncao;
	private String unidade;
	private String natureza;
	private String fonte;
	
	private static final long serialVersionUID = 473322097651004478L;

	@Override
	public Validation<ClassificacaoOrcamentaria> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getSubfuncao() {
		return subfuncao;
	}

	public void setSubfuncao(String subfuncao) {
		this.subfuncao = subfuncao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	
	

}
