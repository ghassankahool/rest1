package com.ghassan.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@Table(name="city")
@XmlRootElement
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cId;
	private String cName;
	private List<Town> towns;

	public City() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_id", unique=true, nullable=false)
	public int getCId() {
		return this.cId;
	}

	public void setCId(int cId) {
		this.cId = cId;
	}


	@Column(name="c_name", nullable=false, length=45)
	public String getCName() {
		return this.cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}


	//bi-directional many-to-one association to Town
	@OneToMany(mappedBy="city")
	@XmlTransient
	public List<Town> getTowns() {
		return this.towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public Town addTown(Town town) {
		getTowns().add(town);
		town.setCity(this);

		return town;
	}

	public Town removeTown(Town town) {
		getTowns().remove(town);
		town.setCity(null);

		return town;
	}

}