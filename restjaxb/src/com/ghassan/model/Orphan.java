package com.ghassan.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orphan database table.
 * 
 */
@Entity
@Table(name="orphan")
@XmlRootElement
public class Orphan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int oId;
	private String brokerContact;
	private String brokerName;
	private Date dateofFD;
	private Date dob;
	private Date docomming;
	private String education;
	private byte gender;
	private String healthStat;
	private String oFatherName;
	private String oMotherName;
	private String oName;
	private byte[] orphanImage;
	private Sector sector;
	private Town town;
	private List<Sponsorship> sponsorships;

	public Orphan() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="o_id", unique=true, nullable=false)
	public int getOId() {
		return this.oId;
	}

	public void setOId(int oId) {
		this.oId = oId;
	}


	@Column(name="broker_contact", nullable=false, length=45)
	public String getBrokerContact() {
		return this.brokerContact;
	}

	public void setBrokerContact(String brokerContact) {
		this.brokerContact = brokerContact;
	}


	@Column(name="broker_name", length=200)
	public String getBrokerName() {
		return this.brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="dateof_f_d", nullable=false)
	public Date getDateofFD() {
		return this.dateofFD;
	}

	public void setDateofFD(Date dateofFD) {
		this.dateofFD = dateofFD;
	}


	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	public Date getDocomming() {
		return this.docomming;
	}

	public void setDocomming(Date docomming) {
		this.docomming = docomming;
	}


	@Column(nullable=false, length=200)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}


	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}


	@Lob
	@Column(name="health_stat")
	public String getHealthStat() {
		return this.healthStat;
	}

	public void setHealthStat(String healthStat) {
		this.healthStat = healthStat;
	}


	@Column(name="o_father_name", length=200)
	public String getOFatherName() {
		return this.oFatherName;
	}

	public void setOFatherName(String oFatherName) {
		this.oFatherName = oFatherName;
	}


	@Column(name="o_mother_name", length=200)
	public String getOMotherName() {
		return this.oMotherName;
	}

	public void setOMotherName(String oMotherName) {
		this.oMotherName = oMotherName;
	}


	@Column(name="o_name", nullable=false, length=200)
	public String getOName() {
		return this.oName;
	}

	public void setOName(String oName) {
		this.oName = oName;
	}


	@Lob
	@Column(name="orphan_image")
	@XmlTransient
	public byte[] getOrphanImage() {
		return this.orphanImage;
	}

	public void setOrphanImage(byte[] orphanImage) {
		this.orphanImage = orphanImage;
	}


	//bi-directional many-to-one association to Sector
	@ManyToOne
	@JoinColumn(name="sec_id", nullable=false)
	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}


	//bi-directional many-to-one association to Town
	@ManyToOne
	@JoinColumn(name="t_id")
	public Town getTown() {
		return this.town;
	}

	public void setTown(Town town) {
		this.town = town;
	}


	//bi-directional many-to-one association to Sponsorship
	@OneToMany(mappedBy="orphan")
	@XmlTransient
	public List<Sponsorship> getSponsorships() {
		return this.sponsorships;
	}

	public void setSponsorships(List<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
	}

	public Sponsorship addSponsorship(Sponsorship sponsorship) {
		getSponsorships().add(sponsorship);
		sponsorship.setOrphan(this);

		return sponsorship;
	}

	public Sponsorship removeSponsorship(Sponsorship sponsorship) {
		getSponsorships().remove(sponsorship);
		sponsorship.setOrphan(null);

		return sponsorship;
	}

}