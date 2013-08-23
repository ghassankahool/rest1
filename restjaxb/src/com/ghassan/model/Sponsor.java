package com.ghassan.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sponsor database table.
 * 
 */
@Entity
@Table(name="sponsor")
public class Sponsor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int sId;
	private String eMail;
	private String homephone;
	private String landphone;
	private String mobile;
	private String sBroker;
	private String sName;
	private String workphone;
	private List<Sponsorship> sponsorships;

	public Sponsor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="s_id", unique=true, nullable=false)
	public int getSId() {
		return this.sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}


	@Column(name="e_mail", length=200)
	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}


	@Column(length=45)
	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}


	@Column(length=45)
	public String getLandphone() {
		return this.landphone;
	}

	public void setLandphone(String landphone) {
		this.landphone = landphone;
	}


	@Column(length=45)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(name="s_broker", length=200)
	public String getSBroker() {
		return this.sBroker;
	}

	public void setSBroker(String sBroker) {
		this.sBroker = sBroker;
	}


	@Column(name="s_name", nullable=false, length=200)
	public String getSName() {
		return this.sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}


	@Column(length=45)
	public String getWorkphone() {
		return this.workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}


	//bi-directional many-to-one association to Sponsorship
	@OneToMany(mappedBy="sponsor")
	public List<Sponsorship> getSponsorships() {
		return this.sponsorships;
	}

	public void setSponsorships(List<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
	}

	public Sponsorship addSponsorship(Sponsorship sponsorship) {
		getSponsorships().add(sponsorship);
		sponsorship.setSponsor(this);

		return sponsorship;
	}

	public Sponsorship removeSponsorship(Sponsorship sponsorship) {
		getSponsorships().remove(sponsorship);
		sponsorship.setSponsor(null);

		return sponsorship;
	}

}