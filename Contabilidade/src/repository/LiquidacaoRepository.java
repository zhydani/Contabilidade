package repository;

import java.util.List;

import javax.persistence.Query;

import model.Liquidacao;

public class LiquidacaoRepository extends Repository<Liquidacao> {

	public List<Liquidacao> findByNumero(String numero) {
		return findByNumero(numero, null);
	}
	
	public List<Liquidacao> findByNumero(String numero, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Liquidacao e ");
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
