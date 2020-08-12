package model.validation;

import java.time.LocalDate;

import application.ValidationException;
import model.Aluno;
import repository.AlunoRepository;

public class AlunoValidation implements Validation<Aluno>{

	@Override
	public void validate(Aluno entity) throws ValidationException {
		validaDataAniversario(entity);
		
		validaEmail(entity);
		
	}

	private void validaEmail(Aluno entity) throws ValidationException {
		AlunoRepository repo = new AlunoRepository();
		if (repo.contains(entity.getId(), entity.getEmail())) {
			throw new ValidationException("Email Inválido. Este e-mail já está sendo utilizado por outro aluno.");
		}
	
	}
	
	private void validaDataAniversario(Aluno entity) throws ValidationException {
		LocalDate data = new java.sql.Date(entity.getDataAniversario().getTime()).toLocalDate(); 
		LocalDate dataLimite = 	LocalDate.now().minusYears(18);
		//data        = 12/05/2020
		//datalimite  = 12/05/2002
		if (data.isAfter(dataLimite)) {
			throw new ValidationException("Data Inválida. O aluno não pode ser menor de idade.");
		}
	}

}
