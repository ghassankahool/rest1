package com.ghassan.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the town database table.
 * 
 */
@Entity
@Table(name="town")
@XmlRootElement
public class Town implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tId;
	private String tName;
	private List<Orphan> orphans;
	private City city;

	public Town() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="t_id", unique=true, nullable=false)
	public int getTId() {
		return this.tId;
	}

	public void setTId(int tId) {
		this.tId = tId;
	}


	@Column(name="t_name", nullable=false, length=45)
	public String getTName() {
		return this.tName;
	}

	public void setTName(String tName) {
		this.tName = tName;
	}


	//bi-directional many-to-one association to Orphan
	@OneToMany(mappedBy="town")
	@XmlTransient
	public List<Orphan> getOrphans() {
		return this.orphans;
	}

	public void setOrphans(List<Orphan> orphans) {
		this.orphans = orphans;
	}

	public Orphan addOrphan(Orphan orphan) {
		getOrphans().add(orphan);
		orphan.setTown(this);

		return orphan;
	}

	
	public Orphan removeOrphan(Orphan orphan) {
		getOrphans().remove(orphan);
		orphan.setTown(null);

		return orphan;
	}


	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="c_id", nullable=false)
	@XmlTransient
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}