package com.ghassan.rest;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ghassan.model.Orphan;

@Path("sponsor")
public class SponsorRest {
	


	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Orphan> getOrphan(){
		
		List<Orphan> lst=new Vector<Orphan>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restjaxb");
		EntityManager em = emf.createEntityManager();
		
		try{
			em.getTransaction().begin();
			//Select all the record from student table
			Query query = em.createQuery("select ph from Orphan ph");
			 lst = query.getResultList();
			em.getTransaction().commit();
			}
			catch(Exception e){
			System.out.println(e.getMessage());
			}
			finally{
			em.close();
			}
		return lst;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	 @Path("{id}")
	public Orphan getOrphanByID(@PathParam("id") String id){
		
		Orphan prph=new Orphan();
		prph.setOId(-1);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restjaxb");
		EntityManager em = emf.createEntityManager();
		
		try{
			em.getTransaction().begin();
			//Select all the record from student table
			Query query = em.createQuery("select ph from Orphan ph where ph.OId =:oid");
			query.setParameter("oid",Integer.parseInt(id) );
			 List<Orphan> lst = query.getResultList();
			 for (Orphan orphan : lst) {
				 prph= orphan;
			}
			em.getTransaction().commit();
			}
			catch(Exception e){
			System.out.println(e.getMessage());
			}
			finally{
			em.close();
			}
		return prph;
	}
	
}
