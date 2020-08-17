package repository;

import java.util.List;

import javax.persistence.Query;

import model.Empenho;

public class EmpenhoRepository extends Repository<Empenho> {

	public List<Empenho> findByNumero(String numero) {
		return findByNumero(numero, null);
	}
	
	public Double findByOrganizacao(String nome) {
		return findByOrganizacao(nome, null);
	}
	
	public List<Empenho> findByNumero(String numero, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append(" Empenho e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.numero) like upper(:numero) ");
		jpql.append("ORDER BY e.numero ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("numero", "%" + numero + "%");
		if (maxResults != null && maxResults > 0 )
			query.setMaxResults(maxResults);

		return query.getResultList();
	}
	
	public Double gastos() {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  SUM(e.valor) as soma ");
		jpql.append("FROM ");
		jpql.append("  Empenho e ");

		Query query = getEntityManager().createQuery(jpql.toString());
		

		return (Double) query.getSingleResult();
	}
	
//	select sum(empenho.valor) from empenho, organizacao where empenho.idorganizacao = organizacao.id and organizacao.nome ilike 'Palmas' 
//			and organizacao.tipoesfera = 1 and organizacao.tipopoder = 1;
	
	public Double findByOrganizacao(String nome, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" SUM(e.valor) as soma  ");
		jpql.append("FROM ");
		jpql.append("  Empenho e, Organizacao o ");
		jpql.append("WHERE ");
		jpql.append("  upper(o.nome) like upper(:nome) ");
		jpql.append(" AND e.organizacao.id = o.id ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");

		return (Double) query.getSingleResult();
	}
	
}
