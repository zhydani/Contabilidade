package repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.Aluno;

public class AlunoRepository extends Repository<Aluno> {

	public List<Aluno> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Aluno a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
	public List<Aluno> findByCidade(Integer id) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Aluno a ");
		if (id != null) {
			jpql.append("WHERE ");
			jpql.append("  a.cidade.id = :id ");
		}
		jpql.append("ORDER BY a.cidade.nome, a.nome");
		

		Query query = getEntityManager().createQuery(jpql.toString());
		if (id != null) 
			query.setParameter("id", id);

		return query.getResultList();
	}	
	
	public boolean contains(Integer id, String email) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  count(*) ");
		sql.append("FROM ");
		sql.append("  Aluno a ");
		sql.append("WHERE ");
		sql.append("  upper(a.email) = upper(?) ");
		sql.append("  AND a.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, email);
		query.setParameter(2, id == null ? -1 : id);
		
		BigInteger resultado = (BigInteger) query.getSingleResult();
		
		return (resultado == null || resultado.equals(BigInteger.ZERO)) ? false : true;
	}
}
