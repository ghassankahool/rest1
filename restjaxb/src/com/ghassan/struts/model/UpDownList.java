package com.ghassan.struts.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ghassan.model.City;
import com.ghassan.model.Town;
import com.opensymphony.xwork2.ActionSupport;

public class UpDownList extends ActionSupport {

	private List<City> cities;
	private List<Town> towns;
	
	private EntityManagerFactory emf ;
	
	public List<City> getCities() {
		 emf = Persistence.createEntityManagerFactory("restjaxb");
			EntityManager em = emf.createEntityManager();
			
			try{
				em.getTransaction().begin();
				//Select all the record from student table
				Query query = em.createQuery("select ct from City ct");
				cities  = query.getResultList();
				 
				em.getTransaction().commit();
				}
				catch(Exception e){
				System.out.println(e.getMessage());
				}
				finally{
				em.close();
				}
		
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<Town> getTowns() {
		 emf = Persistence.createEntityManagerFactory("restjaxb");
			EntityManager em = emf.createEntityManager();
			
			try{
				em.getTransaction().begin();
				//Select all the record from student table
				Query query = em.createQuery("select tw from Town tw");
				towns  = query.getResultList();
				 
				em.getTransaction().commit();
				}
				catch(Exception e){
				System.out.println(e.getMessage());
				}
				finally{
				em.close();
				}
		return towns;
	}
	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
