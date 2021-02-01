package com.semanticsquare.thrillio.constants;

public enum KidFriendlyStatus {
	UNKNOWN("unknown"),
	APPROVED("approved"),
	REJECTED("rejected");
	
	private String name;
	private KidFriendlyStatus(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

