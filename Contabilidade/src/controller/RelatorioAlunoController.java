package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Util;
import model.Aluno;
import model.Cidade;
import repository.AlunoRepository;
import repository.CidadeRepository;

@Named
@ViewScoped
public class RelatorioAlunoController implements Serializable {
	private static final long serialVersionUID = 1042673170088412505L;
	
	private Cidade cidade;
	private List<Cidade> listaCidade;
	private List<Aluno> listaAluno;
	
	public void pesquisar() {
		AlunoRepository repo = new AlunoRepository();
		listaAluno = repo.findByCidade(getCidade().getId());
	}
	
	public void gerarRelatorio() {
		Util.redirect("/faces/alunosCidadeReport?ID_CIDADE="+getCidade().getId());
	}
	
	public void limpar() {
		listaAluno = null;
		listaCidade = null;
		cidade = null;
	}
	
	public List<Aluno> getListaAluno() {
		if (listaAluno == null)
			listaAluno = new ArrayList<Aluno>();
		return listaAluno;
	}

	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repo = new CidadeRepository();
			listaCidade = repo.findByNome("");
		}
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}

	public Cidade getCidade() {
		if (cidade == null)
			cidade = new Cidade();
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
}
