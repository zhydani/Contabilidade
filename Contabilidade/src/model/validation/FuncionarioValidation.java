package model.validation;

import java.time.LocalDate;

import application.ValidationException;
import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioValidation implements Validation<Funcionario>{

	@Override
	public void validate(Funcionario entity) throws ValidationException {
		validaDataAniversario(entity);
		
		validaCpf(entity);
		
	}

	private void validaCpf(Funcionario entity) throws ValidationException {
		FuncionarioRepository repo = new FuncionarioRepository();
		if (repo.contains(entity.getId(), entity.getCpf())) {
			throw new ValidationException("CPF Invalido. Este CPF ja esta sendo utilizado por outro funcionario.");
		}
	
	}
	
	private void validaDataAniversario(Funcionario entity) throws ValidationException {
		LocalDate data = new java.sql.Date(entity.getDataAniversario().getTime()).toLocalDate(); 
		LocalDate dataLimite = 	LocalDate.now().minusYears(18);
		//data        = 12/05/2020
		//datalimite  = 12/05/2002
		if (data.isAfter(dataLimite)) {
			throw new ValidationException("Data Inválida. O funcionario não pode ser menor de idade.");
		}
	}

}
