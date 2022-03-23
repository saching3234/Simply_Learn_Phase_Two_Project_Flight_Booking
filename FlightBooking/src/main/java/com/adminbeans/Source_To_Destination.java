package com.adminbeans;

public class Source_To_Destination {

	private int sdid;
	private String source;
	private String destination;

	// to string method
	@Override
	public String toString() {
		return "Source_To_Destination [sdid=" + sdid + ", source=" + source + ", destination=" + destination + "]";
	}

	// getter and setter
	public int getSdid() {
		return sdid;
	}

	public void setSdid(int sdid) {
		this.sdid = sdid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
