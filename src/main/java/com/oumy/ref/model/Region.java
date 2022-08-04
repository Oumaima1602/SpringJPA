package com.oumy.ref.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "regions_pays")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_region")
	private long id_region;
	
	@Column(name = "region_fr")
	private String region_fr;
	
	@Column(name = "region_ar")
	private String region_ar;
	
	@ManyToOne(
			cascade = { 
					CascadeType.PERSIST, 
					CascadeType.MERGE 
					} 
			)
	@JoinColumn(name = "id_pays")
	private Pays pays;

	public Region(long id_region, String region_fr, String region_ar) {
		super();
		this.id_region = id_region;
		this.region_fr = region_fr;
		this.region_ar = region_ar;
		
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public long getId_region() {
		return id_region;
	}

	public void setId_region(long id_region) {
		this.id_region = id_region;
	}

	public String getRegion_fr() {
		return region_fr;
	}

	public void setRegion_fr(String region_fr) {
		this.region_fr = region_fr;
	}

	public String getRegion_ar() {
		return region_ar;
	}

	public void setRegion_ar(String region_ar) {
		this.region_ar = region_ar;
	}

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Region(Region region) {
		// TODO Auto-generated constructor stub
	}
	
}
