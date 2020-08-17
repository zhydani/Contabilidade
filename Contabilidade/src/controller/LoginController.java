package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Contador;
import repository.ContadorRepository;

@Named
@RequestScoped
public class LoginController {

	private Contador contador;
	
	public String logar() {
		ContadorRepository repo = new ContadorRepository();
		Contador contador = repo.verificarLoginSenha(getContador().getEmail(),
				getContador().getSenha());
		
		if (contador != null) {
			// adicionando um ussuario na sessao
			Session.getInstance().setAttribute("usuarioLogado", contador);
			// redirecionando para o template
			return "pages/index.xhtml?faces-redirect=true";
		}
		Util.addMessageError("Login ou Senha inválido.");
		return "";
	}
	
	public void limpar() {
		contador = null;
	}

	public Contador getContador() {
		if (contador == null)
			contador = new Contador();
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

}
