package repository;

import java.util.List;

import javax.persistence.Query;

import model.Funcionario;

public class FuncionarioRepository extends Repository<Funcionario> {

	public List<Funcionario> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  f ");
		jpql.append("FROM ");
		jpql.append("  Funcionario f ");
		jpql.append("WHERE ");
		jpql.append("  upper(f.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
	public boolean contains(Integer id, String cpf) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  count(*) ");
		jpql.append("FROM ");
		jpql.append("  Funcionario f ");
		jpql.append("WHERE ");
		jpql.append("  upper(f.cpf) = upper(?) ");
		jpql.append("  AND f.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(jpql.toString());

		query.setParameter(1, cpf);
		query.setParameter(2, id == null ? -1 : id);
		
		long resultado = (long) query.getSingleResult();
		
		return resultado == 0 ? false : true;
	}

}
