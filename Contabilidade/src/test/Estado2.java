package test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Estado2 implements Serializable{
	private static final long serialVersionUID = 8576863359925997797L;
	private String sigla;
	@Column(name = "nomeestado")
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
