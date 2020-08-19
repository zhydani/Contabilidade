package repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import model.Contador;

public class ContadorRepository extends Repository<Contador> {

	public List<Contador> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  p ");
		jpql.append("FROM ");
		jpql.append("  Contador p ");
		jpql.append("WHERE ");
		jpql.append("  upper(p.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
	public List<Object[]> findByNomeSql(String nome) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  p.id, p.nome, p.crc ");
		sql.append("FROM ");
		sql.append("  Contador p ");
		sql.append("WHERE ");
		sql.append("  upper(p.nome) like upper(?1) ");

		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, "%" + nome + "%");

		return query.getResultList();
	}
	
	public Contador verificarLoginSenha(String email, String senha) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" 	p ");
		jpql.append("FROM ");
		jpql.append("	Contador p ");
		jpql.append("WHERE ");
		jpql.append("	p.email = :email ");
		jpql.append("	AND p.senha = :senha ");
		
		Query query = getEntityManager().createQuery(jpql.toString());
		
		query.setParameter("email", email);
		query.setParameter("senha", senha);

		try {
			return (Contador) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
	}
	
	public boolean contains(String crc, String cpf) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append("  count(*) ");
		sql.append("FROM");
		sql.append("  Contador p ");
		sql.append("WHERE ");
		sql.append(" upper(p.crc) = upper(?) ");
		sql.append(" AND p.cpf <> ? ");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());
		
		query.setParameter(1, crc);
		query.setParameter(2, cpf == null ? -1 : cpf);
		
		BigInteger resultado = (BigInteger) query.getSingleResult();
		
		return (resultado == null || resultado.equals(BigInteger.ZERO))? false : true ;
	}
	
}
