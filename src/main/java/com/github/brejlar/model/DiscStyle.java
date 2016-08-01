package com.github.brejlar.model;

public enum DiscStyle {
	DISTANCE_DRIVER("Distance Driver"),
	FAIRWAY_DRIVER("Fairway Driver"),
	MID_RANGE("Mid Range"),
	PUTTER("Putter"); 
	
	private String uiString;
	
	private DiscStyle(String uiString) {
		this.uiString = uiString;
	}
	
	public String getUiString() {
		return uiString;
	}
	
	public static DiscStyle parse(String uiString) {
		for(DiscStyle style : values()) {
			if(style.getUiString().equals(uiString)) {
				return style;
			}
		}
		
		return null;
	}
}
