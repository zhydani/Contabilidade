package controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

@Named
@RequestScoped
public class HelloController {
	
	// teste do JPA
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
//		aluno.setId(1);
		aluno.setNome("Joao");
		aluno.setMatricula("123");
		aluno.setDataAniversario(new Date());
		aluno.setEmail("joao@gmail.com");
		
		Aluno aluno2 = new Aluno();
//		aluno.setId(1);
		aluno2.setNome("Maria");
		aluno2.setMatricula("222");
		aluno2.setDataAniversario(new Date());
		aluno2.setEmail("maria@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Academico");
		EntityManager em = emf.createEntityManager();
		
		// iniciando uma transaction
		em.getTransaction().begin();
		em.persist(aluno);
		em.persist(aluno2);
		// finalizando a transaction
		em.getTransaction().commit();
		
	}
	
	private String nome1 = "Juliano";
	private String nome2;
	
	public String getNome1() {
		return nome1;
	}
	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}
	public String getNome2() {
		return nome2;
	}
	public void setNome2(String nome2) {
		this.nome2 = nome2;
	}
	
	

}
