package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EstadoCivil extends DefaultEntity<EstadoCivil> {

	private static final long serialVersionUID = 7782496681898032614L;

	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
