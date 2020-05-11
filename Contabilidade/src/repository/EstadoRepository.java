package repository;

import java.util.List;

import javax.persistence.Query;

import model.Estado;

public class EstadoRepository extends Repository<Estado> {

	public List<Estado> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Estado e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

}
