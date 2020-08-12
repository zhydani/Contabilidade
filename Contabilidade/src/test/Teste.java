package test;

import javax.persistence.EntityManager;

import factory.JPAFactory;

public class Teste {
	public static void main(String[] args) {
		Estado2 estado = new Estado2();
		estado.setNome("Tocantins");
		estado.setSigla("TO");
		Cidade2 cidade = new Cidade2();
		cidade.setId(1);
		cidade.setNome("Palmas");
		cidade.setEstado(estado);
		
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(cidade);
		em.getTransaction().commit();
		System.out.println("Feito.");
		
	}
}
