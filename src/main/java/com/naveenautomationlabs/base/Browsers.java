package com.naveenautomationlabs.base;

public enum Browsers {

	CHROME("Chrome"), EDGE("Edge"), FIREFOX("Firefox");

	private String browserName;

	Browsers(String browserName) {
		this.browserName = browserName;
	}

	public String getBrowserName() {
		return browserName;
	}

}
