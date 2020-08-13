package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.Validation;

@Entity
public class Contador extends DefaultEntity<Contador> {

	private static final long serialVersionUID = 4549513125939281216L;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 20, nullable = false)
	private String matricula;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	@Column(length = 120)
	private String email;
	
	private String senha;
	
	private TipoUsuario tipoUsuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcidade")
	private Cidade cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public Validation<Contador> getValidation() {
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
