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

}
