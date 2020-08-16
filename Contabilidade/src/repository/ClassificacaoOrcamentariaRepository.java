package repository;

import java.util.List;
import java.math.BigInteger;

import javax.persistence.Query;

import model.ClassificacaoOrcamentaria;

public class ClassificacaoOrcamentariaRepository extends Repository<ClassificacaoOrcamentaria> {

	public List<ClassificacaoOrcamentaria> findByNumero(String numero) {
		return findByNumero(numero, null);
	}
	
	public List<ClassificacaoOrcamentaria> findByNumero(String numero, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  ClassificacaoOrcamentaria e ");
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
