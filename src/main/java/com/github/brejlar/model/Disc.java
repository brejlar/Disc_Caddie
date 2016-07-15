package com.github.brejlar.model;

public class Disc {

	private String discId;
	private String model;
	private String ownerId;
	
	public Disc() {
		super();
	}

	public String getDiscId() {
		return discId;
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
	
	public Object[] getFields() {
		return new Object[] {getDiscId(), getModel(), getOwnerId()};
	}

	@Override
	public String toString() {
		return "Disc [discId=" + discId + ", model=" + model + ", ownerId=" + ownerId + "]";
	}
	
}
