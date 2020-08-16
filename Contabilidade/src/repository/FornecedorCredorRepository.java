package repository;

import java.util.List;
import java.math.BigInteger;

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
	
	public boolean contains(Integer id, String cpfcnpj) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  count(*) ");
		sql.append("FROM ");
		sql.append("  FornecedorCredor a ");
		sql.append("WHERE ");
		sql.append("  upper(a.cpfCnpj) = upper(?) ");
		sql.append("  AND a.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, cpfcnpj);
		query.setParameter(2, id == null ? -1 : id);
		
		BigInteger resultado = (BigInteger) query.getSingleResult();
		
		return (resultado == null || resultado.equals(BigInteger.ZERO)) ? false : true;
	}
	
}
