package model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.ContadorValidation;
import model.validation.Validation;

@Entity
public class Contador extends DefaultEntity<Contador> {

	private static final long serialVersionUID = 4549513125939281216L;

	@NotEmpty(message = "O campo Nome não pode ser vazio")
	@Column(length = 100, nullable = false)
	private String nome;

	@NotEmpty(message = "O campo CRC não pode ser vazio")
	@Column(length = 20, nullable = false)
	private String crc;
	
	@NotEmpty(message = "O campo CPF não pode ser vazio")
	@Column(length = 20, nullable = false)
	private String cpf;

	@Past
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	@NotEmpty(message = "O campo E-mail não pode ser vazio")
	@Email
	@Column(length = 120)
	private String email;
	
	@Size(min = 6, max = 30, message = "A senha deve conter entre 6 e 10 caracteres")
	private String senha;
	
	private TipoUsuario tipoUsuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public Validation<Contador> getValidation() {
		return new ContadorValidation();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCrc() {
		return crc;
	}

	public void setCrc(String crc) {
		this.crc = crc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
}
