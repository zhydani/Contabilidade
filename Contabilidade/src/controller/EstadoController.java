package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.EstadoListing;
import model.Estado;

@Named
@ViewScoped
public class EstadoController extends Controller<Estado> {

	private static final long serialVersionUID = 8881610383057468107L;

	@Override
	public Estado getEntity() {
		if (entity == null) {
			entity = new Estado();
		}
		return entity;
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent event) {
        Estado entity = (Estado) event.getObject();
        setEntity(entity);
    }

}
