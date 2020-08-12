package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.CidadeListing;
import model.Cidade;
import model.Estado;
import repository.EstadoRepository;

@Named
@ViewScoped
public class CidadeController extends Controller<Cidade> {
	private static final long serialVersionUID = -333710925757676392L;

	@Override
	public Cidade getEntity() {
		if (entity == null) {
			entity = new Cidade();
			entity.setEstado(new Estado());
		}
		return entity;
	}
	
	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open(null);
	}
	
	public void obterCidadeListing(SelectEvent event) {
        Cidade entity = (Cidade) event.getObject();
        setEntity(entity);
    }
	
	public List<Estado> completeEstado(String filtro) {
		EstadoRepository repo = new EstadoRepository();
		return repo.findByNome(filtro, 11);
	}
	


}
