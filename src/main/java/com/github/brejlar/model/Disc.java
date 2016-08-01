package com.github.brejlar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="disc")
public class Disc {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long discId;
	private String model;
	private String brand;
	private String descriptionText;
	private String ownerId;
	private Integer weight;
	
	private DiscStyle style;
	
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
	
	public Long getDiscId() {
		return discId;
	}

	public void setDiscId(Long discId) {
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

	public DiscStyle getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = DiscStyle.parse(style);
	}

	@Override
	public String toString() {
		return "Disc [discId=" + discId + ", model=" + model + ", brand=" + brand + ", descriptionText="
				+ descriptionText + ", ownerId=" + ownerId + ", weight=" + weight + ", style=" + style + "]";
	}

}
