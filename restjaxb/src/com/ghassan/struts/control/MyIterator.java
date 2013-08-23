package com.ghassan.struts.control;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ghassan.model.Orphan;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class MyIterator extends ActionSupport implements Preparable {

	private List<Orphan> orphanlist;

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

		orphanlist = new Vector<Orphan>();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			// Select all the record from student table
			Query query = em.createQuery("select ph from Orphan ph");
			orphanlist = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(orphanlist!= null){
			return SUCCESS;
		}
		return  ERROR;
	}

	public List<Orphan> getOrphanlist() {
		return orphanlist;
	}

	public void setOrphanlist(List<Orphan> orphanlist) {
		this.orphanlist = orphanlist;
	}

}
