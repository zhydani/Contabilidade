package repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import application.Session;
import application.Util;
import controller.TemplateController;
import model.Contador;

public class ContadorRepository extends Repository<Contador> {

	private Contador contador;

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

		return (resultado == null || resultado.equals(BigInteger.ZERO)) ? false : true;
	}

//	update contador set senha = '123456' where email = 'bea@gmail.com' and senha = '123';  
	public void trocarSenha(String email, String novasenha, String senha) {

		StringBuffer sql = new StringBuffer();

		sql.append("UPDATE ");
		sql.append(" contador ");
		sql.append(" SET ");
		sql.append(" senha = ? ");
		sql.append(" WHERE ");
		sql.append(" email = ? ");
		sql.append(" AND senha = ?");

		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, novasenha);
		query.setParameter(2, email);
		query.setParameter(3, senha);

		try {
			Util.addMessageInfo("atualização realizado com sucesso");
			System.out.println(query.getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
