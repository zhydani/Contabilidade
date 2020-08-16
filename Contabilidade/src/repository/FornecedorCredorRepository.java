package repository;

import java.util.List;

import javax.persistence.Query;

import model.FornecedorCredor;

public class FornecedorCredorRepository extends Repository<FornecedorCredor> {

	public List<FornecedorCredor> findByNome(String nome) {
		return findByNome(nome, null);
	}
	
	public List<FornecedorCredor> findByNome(String nome, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  FornecedorCredor e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");
		jpql.append("ORDER BY e.nome ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		if (maxResults != null && maxResults > 0 )
			query.setMaxResults(maxResults);

		return query.getResultList();
	}
	
}
