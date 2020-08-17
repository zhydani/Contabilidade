package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Empenho;
import repository.EmpenhoRepository;
import repository.LiquidacaoRepository;
import repository.PagamentoRepository;

@Named
@ViewScoped
public class Gastos extends Listing<Empenho> {

	private static final long serialVersionUID = 2921753168434872389L;
	
	private Double empenhovalor;
	private Double liquidacaovalor;
	private Double pagamentovalor;

	public Gastos() {
		super(Empenho.class);
	}
	
	

	public void empenho() {
		EmpenhoRepository repo = new EmpenhoRepository();
		setEmpenhovalor(repo.gastos());
	}
	
	public void liquidacao() {
		LiquidacaoRepository repo = new LiquidacaoRepository();
		setLiquidacaovalor(repo.gastos());
	}
	
	public void pagamento() {
		PagamentoRepository repo = new PagamentoRepository();
		setPagamentovalor(repo.gastos());
	}



	public Double getLiquidacaovalor() {
		return liquidacaovalor;
	}



	public void setLiquidacaovalor(Double liquidacaovalor) {
		this.liquidacaovalor = liquidacaovalor;
	}



	public Double getEmpenhovalor() {
		return empenhovalor;
	}



	public void setEmpenhovalor(Double empenhovalor) {
		this.empenhovalor = empenhovalor;
	}



	public Double getPagamentovalor() {
		return pagamentovalor;
	}



	public void setPagamentovalor(Double pagamentovalor) {
		this.pagamentovalor = pagamentovalor;
	}



	
	

	

	

}
