package model;

import java.util.ArrayList;
import java.util.List;

public enum TipoUsuario {
	
	ADMINISTRADOR(1, "Adminstrador"), 
	FUNCIONARIO(2, "Professor");
	
	private int id;
	private String label;
	private List<String> paginasAcesso = null;
	
	private TipoUsuario(int id, String label) {
		this.id = id;
		this.label = label;
		paginasAcesso = new ArrayList<String>();
		if (id == 1) {
			paginasAcesso.add("pages/aluno.xhtml");
			paginasAcesso.add("pages/alunolisting.xhtml");
			paginasAcesso.add("pages/professor.xhtml");
			paginasAcesso.add("pages/professorlisting.xhtml");
			paginasAcesso.add("pages/professorlistingsql.xhtml");
			paginasAcesso.add("pages/estado.xhtml");
			paginasAcesso.add("pages/estadolisting.xhtml");
			paginasAcesso.add("pages/cidade.xhtml");
			paginasAcesso.add("pages/cidadelisting.xhtml");
			paginasAcesso.add("pages/relatorioaluno.xhtml");
			paginasAcesso.add("img-professor");
		} else {
			paginasAcesso.add("pages/aluno.xhtml");
			paginasAcesso.add("pages/estado.xhtml");
			paginasAcesso.add("pages/cidade.xhtml");
		}
		
	}
	
	public List<String> getPaginasAcesso() {
		return paginasAcesso;
	}

	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static TipoUsuario valueOf(Integer valor) {
		for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
			if (valor == tipoUsuario.getId())
				return tipoUsuario;
		} 
		return null;
	}
	
}
