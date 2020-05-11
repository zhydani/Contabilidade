package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Empresa extends DefaultEntity<Empresa> {

	private static final long serialVersionUID = 7782496681898032614L;

	@Column(nullable = false)
	private String razaosocial;
	private String cnpj;
	
	
	public String getRazaosocial() {
		return razaosocial;
	}
	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
}
