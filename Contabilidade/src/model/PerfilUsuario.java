package model;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

	public class PerfilUsuario implements Cloneable {

		private Integer id;
		
		@NotEmpty(message = "O campo Nome não pode ser vazio")
		private String nome;
		
		@Email
		private String login;
		
		@Size(min = 6, max = 30, message = "A senha deve conter entre 6 e 8 caracteres")
		private String senha;
		
		@Past
		private LocalDate dataAniversario;
		
		private Boolean ativo = Boolean.TRUE;
		
		private TipoUsuario tipoUsuario;

		public PerfilUsuario() {
			super();
		}

		public PerfilUsuario(Integer id, String nome, String login, String senha, Boolean ativo, LocalDate data) {
			super();
			this.id = id;
			this.nome = nome;
			this.login = login;
			this.senha = senha;
			this.ativo = ativo;
			this.dataAniversario = data;
			
		}

		@Override
		public PerfilUsuario clone() {
			try {
				return (PerfilUsuario) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				System.out.println("Erro ao clonar.");
			}
			return null;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PerfilUsuario other = (PerfilUsuario) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

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

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public LocalDate getDataAniversario() {
			return dataAniversario;
		}

		public void setDataAniversario(LocalDate dataAniversario) {
			this.dataAniversario = dataAniversario;
		}

		public Boolean getAtivo() {
			return ativo;
		}

		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}

		

		public TipoUsuario getPerfil() {
			return tipoUsuario;
		}

		public void setPerfil(TipoUsuario tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}

	}
