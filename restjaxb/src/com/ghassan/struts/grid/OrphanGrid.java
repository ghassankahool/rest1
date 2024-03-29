package com.ghassan.struts.grid;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Result;

import com.ghassan.model.Orphan;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/grid")
@ResultPath("/")
@ParentPackage("json-default")
public class OrphanGrid extends ActionSupport {

	private List<Orphan> listorphan;
	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	private Integer rows = 0;

	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;

	// sorting order - asc or desc
	private String sord;

	// get index row - i.e. user click to sort.
	private String sidx;

	// Search Field
	private String searchField;

	// The Search String
	private String searchString;

	// he Search Operation
	// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String searchOper;

	// Your Total Pages
	private Integer total = 0;

	// All Record
	private Integer records = 0;

	@Actions({ @Action(value = "jsontable", results = { @Result(name = "success", type = "json") }),
		@Action(value = "orphangrid", results = { @Result(name = "success", location="orphangrid.jsp") })})
	public String execute() {

		int to = (rows * page);
		int from = to - rows;
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("restjaxb");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			// Select all the record from student table
			Query query = em
					.createQuery("select ph from Orphan ph ");
			
			listorphan = query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

		// Count Rows (select count(*) from custumer)
		records = listorphan.size();

		// Your logic to search and select the required data.

		// calculate the total pages for the query
		total = (int) Math.ceil((double) records / (double) rows);

		return SUCCESS;
	}
	
	public List<Orphan> getListorphan() {
		return listorphan;
	}

	public void setListorphan(List<Orphan> listorphan) {
		this.listorphan = listorphan;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public String getJSON()
	  {
	    return execute();
	  }

}
