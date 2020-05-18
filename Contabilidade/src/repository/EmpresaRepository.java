package repository;

import java.util.List;

import javax.persistence.Query;

import model.Empresa;

public class EmpresaRepository extends Repository<Empresa> {

	public List<Empresa> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Empresa e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
	public boolean contains(Integer id, String cnpj) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  count(*) ");
		jpql.append("FROM ");
		jpql.append("  Funcionario f ");
		jpql.append("WHERE ");
		jpql.append("  upper(f.cnpj) = upper(?) ");
		jpql.append("  AND f.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(jpql.toString());

		query.setParameter(1, cnpj);
		query.setParameter(2, id == null ? -1 : id);
		
		long resultado = (long) query.getSingleResult();
		
		return resultado == 0 ? false : true;
	}

}
