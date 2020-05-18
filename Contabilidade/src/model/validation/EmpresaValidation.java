package model.validation;


import application.ValidationException;
import model.Empresa;
import repository.EmpresaRepository;

public class EmpresaValidation implements Validation<Empresa>{

	@Override
	public void validate(Empresa entity) throws ValidationException {
		
		validaCnpj(entity);
		
	}

	private void validaCnpj(Empresa entity) throws ValidationException {
		EmpresaRepository repo = new EmpresaRepository();
		if (repo.contains(entity.getId(), entity.getCnpj())) {
			throw new ValidationException("CNPJ Invalido. Este CNPJ ja esta sendo utilizado por outra empresa.");
		}
	
	}
	

}
