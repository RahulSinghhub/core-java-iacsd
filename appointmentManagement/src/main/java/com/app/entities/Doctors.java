package com.app.entities;

public class Doctors {
	private int did;
	private String docname;
	private String issue;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "Doctors [did=" + did + ", docname=" + docname + ", issue=" + issue + "]";
	}
	public Doctors(int did, String docname, String issue) {
		super();
		this.did = did;
		this.docname = docname;
		this.issue = issue;
	}
	
}
