package com.ghassan.struts.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ghassan.model.*;

public class OrphanByID extends ActionSupport  implements ModelDriven{
	
	
	
	private EntityManagerFactory emf ;
	Orphan orphan=new Orphan();
	private List<City> citys;

	public List<City> getCitys() {
		 emf = Persistence.createEntityManagerFactory("restjaxb");
			EntityManager em = emf.createEntityManager();
			
			try{
				em.getTransaction().begin();
				//Select all the record from student table
				Query query = em.createQuery("select ct from City ct");
				citys  = query.getResultList();
				 
				em.getTransaction().commit();
				}
				catch(Exception e){
				System.out.println(e.getMessage());
				}
				finally{
				em.close();
				}
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
	
		
		
		return orphan;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 emf = Persistence.createEntityManagerFactory("restjaxb");
			EntityManager em = emf.createEntityManager();
			
			try{
				em.getTransaction().begin();
				//Select all the record from student table
				Query query = em.createQuery("select ph from Orphan ph where ph.OId = :oid");
				HttpServletRequest request = ServletActionContext.getRequest();
				query.setParameter("oid",Integer.parseInt(request.getParameter("id")) );
				 List<Orphan> lst = query.getResultList();
				 for (Orphan orphan1 : lst) {
					 orphan= orphan1;
				}
				em.getTransaction().commit();
				}
				catch(Exception e){
				System.out.println(e.getMessage());
				}
				finally{
				em.close();
				}
		return "SUCCESS";
	}
	
	public Orphan getOrphan() {
		return orphan;
	}

	public void setOrphan(Orphan orphan) {
		this.orphan = orphan;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

}
