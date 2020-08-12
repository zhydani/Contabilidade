package test;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade2 implements Serializable{
	private static final long serialVersionUID = -6331362509957620260L;
	@Id
	private Integer id;
	private String nome;
	@Embedded
	private Estado2 estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado2 getEstado() {
		return estado;
	}

	public void setEstado(Estado2 estado) {
		this.estado = estado;
	}

}
