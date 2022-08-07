package com.oumy.ref.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pays")
public class Pays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pays")
	private long id_pays;
	
	@Column(name= "pays_fr")
	private String pays_fr;
	
	@OneToMany(
			mappedBy = "pays",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Region> regions = new ArrayList<>();

	public Pays() {
		super();
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public long getId_pays() {
		return id_pays;
	}

	public void setId_pays(long id_pays) {
		this.id_pays = id_pays;
	}

	public String getPays_fr() {
		return pays_fr;
	}

	public void setPays_fr(String pays_fr) {
		this.pays_fr = pays_fr;
	}

	public Pays(String pays_fr) {
		super();
		this.pays_fr = pays_fr;
	}

	
	public void addRegion(Region region) {
		regions.add(region);
		region.setPays(this);
	}
 
	public void removeRegion(Region region) {
		regions.remove(region);
		region.setPays(null);
	}

}
