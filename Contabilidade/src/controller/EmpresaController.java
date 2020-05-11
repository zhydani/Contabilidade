package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.EmpresaListing;
import model.Empresa;

@Named
@ViewScoped
public class EmpresaController extends Controller<Empresa> {

	private static final long serialVersionUID = 8881610383057468107L;

	@Override
	public Empresa getEntity() {
		if (entity == null) {
			entity = new Empresa();
		}
		return entity;
	}
	
	public void abrirEmpresaListing() {
		EmpresaListing listing = new EmpresaListing();
		listing.open();
	}
	
	public void obterEmpresaListing(SelectEvent event) {
        Empresa entity = (Empresa) event.getObject();
        setEntity(entity);
    }

}
