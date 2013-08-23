package com.ghassan.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sponsorship database table.
 * 
 */
@Entity
@Table(name="sponsorship")
public class Sponsorship implements Serializable {
	private static final long serialVersionUID = 1L;
	private int spId;
	private Date beginDate;
	private Date docDate;
	private String docNumber;
	private int period;
	private BigDecimal value;
	private Orphan orphan;
	private Sponsor sponsor;

	public Sponsorship() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sp_id", unique=true, nullable=false)
	public int getSpId() {
		return this.spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="begin_date", nullable=false)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="doc_date", nullable=false)
	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}


	@Column(name="doc_number", nullable=false, length=45)
	public String getDocNumber() {
		return this.docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}


	@Column(nullable=false)
	public int getPeriod() {
		return this.period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}


	//bi-directional many-to-one association to Orphan
	@ManyToOne
	@JoinColumn(name="o_id", nullable=false)
	public Orphan getOrphan() {
		return this.orphan;
	}

	public void setOrphan(Orphan orphan) {
		this.orphan = orphan;
	}


	//bi-directional many-to-one association to Sponsor
	@ManyToOne
	@JoinColumn(name="s_id", nullable=false)
	public Sponsor getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

}