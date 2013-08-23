package com.ghassan.struts.model;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/model")
@ResultPath(value = "/")
@ParentPackage(value = "gl")
public class OrphanImageById extends ActionSupport {

	private static Logger log = Logger.getLogger(OrphanById2.class);

	private InputStream orphanimage;

	public InputStream getOrphanimage() {
		return orphanimage;
	}

	public void setOrphanimage(InputStream orphanimage) {
		this.orphanimage = orphanimage;
	}

	@Action(value = "orphanimageid", results = { @Result(name = "success", type = "stream", params = {
			"contentType", "image/jpeg", "inputName", "orphanimage" }) })
	public String OrphanImage() {
		Orphan ob = new Orphan();
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
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
			if (ob.getOrphanImage()!=null) {
				orphanimage = new ByteArrayInputStream(ob.getOrphanImage());
			} else {
				try {
					log.info("try : " + ob.getOId());
					orphanimage = new FileInputStream("../images/no-avatar.jpg");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					log.info(e.getMessage());
					e.printStackTrace();
				}
			}
			return SUCCESS;

		} else {

			return SUCCESS;
		}

	}
}
