package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.FornecedorCredorListing;
import model.FornecedorCredor;

@Named
@ViewScoped
public class FornecedorCredorController extends Controller<FornecedorCredor> {

	private static final long serialVersionUID = 8881610383057468107L;

	@Override
	public FornecedorCredor getEntity() {
		if (entity == null) {
			entity = new FornecedorCredor();
		}
		return entity;
	}
	
	public void abrirFornecedorCredorListing() {
		FornecedorCredorListing listing = new FornecedorCredorListing();
		listing.open();
	}
	
	public void obterFornecedorCredorListing(SelectEvent event) {
        FornecedorCredor entity = (FornecedorCredor) event.getObject();
        setEntity(entity);
    }

}
