package com.project.jarvece;

public class Session {
	private static Session instance;

	private Session() {}

	public void openNewSession() {
	}

	public static Session getInstance() {
		if (instance == null) {
			instance = new Session();
		}
		return instance;
	}


}
