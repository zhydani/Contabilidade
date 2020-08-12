package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.AlunoValidation;
import model.validation.Validation;

@Entity
public class Aluno extends DefaultEntity<Aluno> {

	private static final long serialVersionUID = 8808841694013495869L;

	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 20, nullable = false)
	private String matricula;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	
	@Column(length = 120)
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "idcidade", nullable = true)
	private Cidade cidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtelefone", unique = true)
	private Telefone telefone;
	
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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public Validation<Aluno> getValidation() {
		return new AlunoValidation();
	}
	
}
