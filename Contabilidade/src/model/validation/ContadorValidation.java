package model.validation;

import application.ValidationException;
import model.Contador;
import repository.ContadorRepository;

public class ContadorValidation implements Validation<Contador>{

	@Override
	public void validate(Contador entity) throws ValidationException {
		 
		validaCrcCpf(entity);
		
		
	}
	
	private void validaCrcCpf(Contador entity) throws ValidationException {
		ContadorRepository repo = new ContadorRepository();
		if(repo.contains((entity.getCrc()), entity.getCpf())) {
			throw new ValidationException("CRC ou Cpf Inválido, pois já está sendo utilizado por outro Contador");
		}
	}

}
