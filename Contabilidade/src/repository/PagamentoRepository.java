package repository;

import java.util.List;

import javax.persistence.Query;

import model.Pagamento;

public class PagamentoRepository extends Repository<Pagamento> {

	public List<Pagamento> findByNumero(String numero) {
		return findByNumero(numero, null);
	}
	
	public List<Pagamento> findByNumero(String numero, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Pagamento e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.numero) like upper(:numero) ");
		jpql.append("ORDER BY e.numero ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("numero", "%" + numero + "%");
		if (maxResults != null && maxResults > 0 )
			query.setMaxResults(maxResults);

		return query.getResultList();
	}
	
	
}
