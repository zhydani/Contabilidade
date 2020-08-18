package model.validation;


import application.ValidationException;
import model.FornecedorCredor;
import repository.FornecedorCredorRepository;

public class FornecedorCredorValidation implements Validation<FornecedorCredor>{

	@Override
	public void validate(FornecedorCredor entity) throws ValidationException {
		
		validaCpfCnpj(entity);
		
	}

	private void validaCpfCnpj(FornecedorCredor entity) throws ValidationException {
		FornecedorCredorRepository repo = new FornecedorCredorRepository();
		if (repo.contains(entity.getId(), entity.getCpfCnpj())) {
			throw new ValidationException("CPF ou CNPJ Inválido, pois o mesmo já está sendo utilizado por outro Fornecedor ou Credor.");
		}
	
	}
	
	
}
