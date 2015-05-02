package com.unbosque.info.dao;

import com.unbosque.info.entidad.Dieta;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DietaDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addDieta(Dieta dieta) {
		getSessionFactory().getCurrentSession().save(dieta);

	}

	public void deleteDieta(Dieta dieta) {
		getSessionFactory().getCurrentSession().delete(dieta);
	}

	public void updateDieta(Dieta dieta) {
		getSessionFactory().getCurrentSession().update(dieta);
	}

	public Dieta getDietaById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Dieta where id=?").setParameter(0, id)
				.list();
		return (Dieta) list.get(0);
	}

	public List<Dieta> getDietas() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Dieta").list();
		return list;
	}

}