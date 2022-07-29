package com.project.complaint.servlet;

public class ComplaintEntity {
	private int cid;
	private int pid;
	private String comment;
	private String username;
	private String status;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public ComplaintEntity(int cid, int pid, String comment, String username, String status) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.comment = comment;
		this.username = username;
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public ComplaintEntity() {
		super();
		
	}
	
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
