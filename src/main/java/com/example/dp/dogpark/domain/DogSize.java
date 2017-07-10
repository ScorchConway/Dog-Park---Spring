package com.example.dp.dogpark.domain;

/**
 * Enumeration of dog sizes
 * @author scottconner
 */
public enum DogSize {
	Tiny("tiny"),
	Small("small"),
	Medium("medium"),
	Large("large"),
	Really_Large("really large");
	
	private String label;
	
	private DogSize(String label) {
		this.label = label;
	}
	
	public static DogSize findByLabel(String byLabel) {
		for(DogSize s : DogSize.values()) {
			if(s.label.equalsIgnoreCase(byLabel))
				return s;
		}
		return null;
	}
}
