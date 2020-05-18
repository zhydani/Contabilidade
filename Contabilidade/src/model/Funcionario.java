package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.FuncionarioValidation;
import model.validation.Validation;

@Entity
public class Funcionario extends DefaultEntity<Funcionario> {

	private static final long serialVersionUID = 8808841694013495869L;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(length = 50, nullable = false)
	private String rg;

	@Column(length = 200, nullable = false)
	private String funcao;

	@Column(length = 20, nullable = false)
	private Double salario;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataRecisao;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataFerias;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataAfastamento;

	@ManyToOne
	@JoinColumn(name = "idempresa")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "idestadocivil")
	private EstadoCivil estadocivil;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataRecisao() {
		return dataRecisao;
	}

	public void setDataRecisao(Date dataRecisao) {
		this.dataRecisao = dataRecisao;
	}

	public Date getDataFerias() {
		return dataFerias;
	}

	public void setDataFerias(Date dataFerias) {
		this.dataFerias = dataFerias;
	}

	public Date getDataAfastamento() {
		return dataAfastamento;
	}

	public void setDataAfastamento(Date dataAfastamento) {
		this.dataAfastamento = dataAfastamento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public Validation<Funcionario> getValidation() {
		return new FuncionarioValidation();
	}

}
