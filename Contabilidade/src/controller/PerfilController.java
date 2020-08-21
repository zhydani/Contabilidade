package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Contador;
import repository.ContadorRepository;

@Named
@ViewScoped
public class PerfilController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8698312443334012061L;
	private Contador usuarioLogado = null;
	private String senha;
	private String novasenha;
	
	public void update() {
		System.out.println(novasenha);
		usuarioLogado = (Contador) Session.getInstance().getAttribute("usuarioLogado");		
		System.out.println(usuarioLogado.getEmail());
		System.out.println(senha);
		ContadorRepository repo = new ContadorRepository();
		repo.trocarSenha(usuarioLogado.getEmail(), novasenha, senha);
		
		
	}
	
	
	

	public String getNovasenha() {
		return novasenha;
	}

	public void setNovasenha(String novasenha) {
		this.novasenha = novasenha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
