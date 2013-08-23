package com.ghassan.struts.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.ghassan.model.Orphan;
import com.ghassan.model.Sector;
import com.ghassan.model.Town;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/model")
@ResultPath(value = "/")
@ParentPackage(value = "gl")
public class OrphanById2 extends ActionSupport {

	private static Logger log = Logger.getLogger(OrphanById2.class);

	private InputStream orphanimage;

	public InputStream getOrphanimage() {
		return orphanimage;
	}

	public void setOrphanimage(InputStream orphanimage) {
		this.orphanimage = orphanimage;
	}

	@Action(value = "orphanimage", results = { @Result(name = "success", type = "stream", params = {
			"contentType", "image/jpeg" 
			,"inputName","orphanimage"}) })
	public String OrphanImage() {
		Orphan ob = new Orphan();
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
		log.info("execute 123");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Orphan> cq = cb.createQuery(Orphan.class);
		Root<Orphan> c = cq.from(Orphan.class);
		cq.where(cb.equal(c.get("OId"), id));
		List<Orphan> list = em.createQuery(cq).getResultList();
		for (Orphan orph : list) {
			ob = orph;
		}
		if (list.size() > 0) {
			log.info("image" + ob.getOId());
			orphanimage = new ByteArrayInputStream(ob.getOrphanImage());
			return SUCCESS;
		} else {
			return INPUT;
		}

	}

	private int sec_id;
	private int town_id;

	public int getSec_id() {
		sec_id = orphan.getSector().getSecId();
		return sec_id;
	}

	public void setSec_id(int sec_id) {
		this.sec_id = sec_id;
	}

	public int getTown_id() {
		town_id = orphan.getTown().getTId();
		return town_id;
	}

	public void setTown_id(int town_id) {
		this.town_id = town_id;
	}

	public static Gender[] gendersarr = { new Gender(0, "Male"),
			new Gender(1, "Female") };

	List<Gender> genders = new ArrayList<OrphanById2.Gender>();

	public List<Gender> getGenders() {
		genders.add(gendersarr[0]);
		genders.add(gendersarr[1]);
		return genders;
	}

	public void setGenders(List<Gender> genders) {

		this.genders = genders;
	}

	public List<Town> getTowns() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select t from Town t");
		towns = q.getResultList();
		return towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public List<Sector> getSectors() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select s from Sector s");
		sectors = q.getResultList();
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	Orphan orphan = new Orphan();

	List<Town> towns;
	List<Sector> sectors;

	public Orphan getOrphan() {
		return orphan;
	}

	public void setOrphan(Orphan orphan) {
		this.orphan = orphan;
	}

	@Action(value = "orphanbyid", results = {
			@Result(name = "success", location = "orphanid.jsp"),
			@Result(name = "input", location = "orphanid.jsp") })
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
		log.info("execute 123");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Orphan> cq = cb.createQuery(Orphan.class);
		Root<Orphan> c = cq.from(Orphan.class);
		cq.where(cb.equal(c.get("OId"), id));
		List<Orphan> list = em.createQuery(cq).getResultList();
		for (Orphan orph : list) {
			orphan = orph;
		}
		if (list.size() > 0) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	@Action(value = "saveorphan", results = {
			@Result(name = "success", location = "orphanid.jsp"),
			@Result(name = "input", location = "orphanid.jsp") })
	public String SaveOrphan() {
		log.info("save action");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Sector sec = new Sector();
		sec.setSecId(sec_id);
		orphan.setSector(sec);

		Town town = new Town();
		town.setTId(town_id);
		orphan.setTown(town);

		log.info("sec_id=" + orphan.getSector().getSecId());
		log.info("town_id=" + orphan.getTown().getTId());
		log.info("save orphan");
		em.merge(orphan);
		em.getTransaction().commit();
		log.info("saved");
		return SUCCESS;
	}

	static public class Gender {

		public Gender(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
