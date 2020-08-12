package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Professor;
import repository.ProfessorRepository;

@Named
@RequestScoped
public class LoginController {

	private Professor professor;
	
	public String logar() {
		ProfessorRepository repo = new ProfessorRepository();
		Professor professor = repo.verificarLoginSenha(getProfessor().getEmail(),
				getProfessor().getSenha());
		
		if (professor != null) {
			// adicionando um ussuario na sessao
			Session.getInstance().setAttribute("usuarioLogado", professor);
			// redirecionando para o template
			return "pages/professor.xhtml?faces-redirect=true";
		}
		Util.addMessageError("Login ou Senha inválido.");
		return "";
	}
	
	public void limpar() {
		professor = null;
	}

	public Professor getProfessor() {
		if (professor == null)
			professor = new Professor();
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
