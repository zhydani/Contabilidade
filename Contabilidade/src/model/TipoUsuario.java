package model;

import java.util.ArrayList;
import java.util.List;

public enum TipoUsuario {
	
	ADMINISTRADOR(1, "Adminstrador"), 
	FUNCIONARIO(2, "Contador");
	
	private int id;
	private String label;
	private List<String> paginasAcesso = null;
	
	private TipoUsuario(int id, String label) {
		this.id = id;
		this.label = label;
		paginasAcesso = new ArrayList<String>();
		if (id == 1) {
			paginasAcesso.add("pages/index.xhtml");
			paginasAcesso.add("pages/contador.xhtml");
			paginasAcesso.add("pages/contadorlisting.xhtml");
			paginasAcesso.add("pages/contadorlistingsql.xhtml");
			paginasAcesso.add("pages/organizacao.xhtml");
			paginasAcesso.add("pages/organizacaolisting.xhtml");
			paginasAcesso.add("pages/empenho.xhtml");
			paginasAcesso.add("pages/empenholisting.xhtml");
			paginasAcesso.add("pages/liquidacao.xhtml");
			paginasAcesso.add("pages/liquidacaolisting.xhtml");
			paginasAcesso.add("pages/pagamento.xhtml");
			paginasAcesso.add("pages/pagamentolisting.xhtml");
			paginasAcesso.add("pages/classificacao-orcamentaria.xhtml");
			paginasAcesso.add("pages/classificacaoorcamentarialisting.xhtml");
			paginasAcesso.add("pages/fornecedor-credor.xhtml");
			paginasAcesso.add("pages/fornecedorcredorlisting.xhtml");
		} else {
			paginasAcesso.add("pages/empenho.xhtml");
			paginasAcesso.add("pages/empenholisting.xhtml");
			paginasAcesso.add("pages/liquidacao.xhtml");
			paginasAcesso.add("pages/liquidacaolisting.xhtml");
			paginasAcesso.add("pages/pagamento.xhtml");
			paginasAcesso.add("pages/pagamentolisting.xhtml");
			
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
