package org.walsted.hello.fish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fish")
public class Fish {

	private Long id;

	private String className;

	private String orderName;

	private String familyName;

	private String genusName;

	private String speciesName;

	private String commonName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fish_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "order_name")
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Column(name = "family_name")
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Column(name = "genus_name")
	public String getGenusName() {
		return genusName;
	}

	public void setGenusName(String genusName) {
		this.genusName = genusName;
	}

	@Column(name = "species_name")
	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	@Column(name = "common_name")
	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", className=" + className + ", orderName=" + orderName + ", familyName=" + familyName
				+ ", genusName=" + genusName + ", speciesName=" + speciesName + ", commonName=" + commonName + "]";
	}

}
