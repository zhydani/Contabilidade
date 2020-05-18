package controller;

import java.io.Serializable;

import javax.persistence.EntityManager;

import application.RepositoryException;
import application.Util;
import application.ValidationException;
import factory.JPAFactory;
import model.DefaultEntity;
import repository.Repository;

public abstract class Controller<T extends DefaultEntity<T>> implements Serializable {

	private static final long serialVersionUID = -8001629045854908916L;
	protected T entity;
	
	public abstract T getEntity();

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Controller() {
		super();
	}

	public void salvar() {
		Repository<T> r = new Repository<T>();
		try {
			if (getEntity().getValidation() != null)
				getEntity().getValidation().validate(getEntity());
			r.beginTransaction();
			r.salvar(getEntity());
			r.commitTransaction();	
		} catch (RepositoryException e) {
			e.printStackTrace();
			r.rollbackTransaction();
			Util.addMessageError("Problema ao salvar.");
			return;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			Util.addMessageError(e.getMessage());
			return;
		}
		limpar();
		Util.addMessageInfo("Cadastro realizado com sucesso.");
	}

	public void excluir() {
		Repository<T> r = new Repository<T>();
		try {
			r.beginTransaction();
			r.excluir(getEntity());
			r.commitTransaction();	
		} catch (RepositoryException e) {
			e.printStackTrace();
			r.rollbackTransaction();
			Util.addMessageError("Problema ao excluir.");
			return;
		}
		limpar();
		Util.addMessageInfo("Exclusão realizada com sucesso.");	
	}
	
	public void editar(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		setEntity((T) em.find(getEntity().getClass(), id));
	}
	
	public void limpar() {
		entity = null;
	}

}