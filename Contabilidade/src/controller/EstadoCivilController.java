package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.EstadoCivilListing;
import model.EstadoCivil;

@Named
@ViewScoped
public class EstadoCivilController extends Controller<EstadoCivil> {

	private static final long serialVersionUID = 8881610383057468107L;

	@Override
	public EstadoCivil getEntity() {
		if (entity == null) {
			entity = new EstadoCivil();
		}
		return entity;
	}
	
	public void abrirEstadoCivilListing() {
		EstadoCivilListing listing = new EstadoCivilListing();
		listing.open();
	}
	
	public void obterEstadoCivilListing(SelectEvent event) {
        EstadoCivil entity = (EstadoCivil) event.getObject();
        setEntity(entity);
    }

}
