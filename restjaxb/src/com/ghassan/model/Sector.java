package com.ghassan.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the sector database table.
 * 
 */
@Entity
@Table(name="sector")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;
	private int secId;
	private String secName;
	private List<Orphan> orphans;

	public Sector() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sec_id", unique=true, nullable=false)
	public int getSecId() {
		return this.secId;
	}

	public void setSecId(int secId) {
		this.secId = secId;
	}


	@Column(name="sec_name", nullable=false, length=45)
	public String getSecName() {
		return this.secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}


	//bi-directional many-to-one association to Orphan
	@OneToMany(mappedBy="sector")
	@XmlTransient
	public List<Orphan> getOrphans() {
		return this.orphans;
	}

	public void setOrphans(List<Orphan> orphans) {
		this.orphans = orphans;
	}

	public Orphan addOrphan(Orphan orphan) {
		getOrphans().add(orphan);
		orphan.setSector(this);

		return orphan;
	}

	public Orphan removeOrphan(Orphan orphan) {
		getOrphans().remove(orphan);
		orphan.setSector(null);

		return orphan;
	}

}