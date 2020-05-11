package repository;

import java.util.List;

import javax.persistence.Query;

import model.Empresa;
import model.EstadoCivil;

public class EstadoCivilRepository extends Repository<Empresa> {

	public List<EstadoCivil> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  EstadoCivil e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

}
