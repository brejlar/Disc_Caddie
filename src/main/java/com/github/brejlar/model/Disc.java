package com.github.brejlar.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Disc {

	private String discId;
	private String model;
	private String brand;
	private String descriptionText;
	private String ownerId;
	private Integer weight;
	
	public Disc() {
		super();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}
	
	public String getDiscId() {
		return String.valueOf(new Date().getTime());
	}

	public void setDiscId(String discId) {
		this.discId = discId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@JsonIgnore
	public Object[] getFields() {
		return new Object[] { getDiscId(), getModel(), getOwnerId(), getBrand(), getDescriptionText(), getWeight() };
	}

	@Override
	public String toString() {
		return "Disc [discId=" + discId + ", model=" + model + ", ownerId=" + ownerId + ", brand=" + brand + ", weight= " + weight + ", descriptionText=" + descriptionText + "]";
	}

}
