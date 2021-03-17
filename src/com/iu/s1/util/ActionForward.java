package com.iu.s1.util;

public class ActionForward {
	
	private String path;
	
	private boolean check; //check true라면foward, false라면 redi

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
