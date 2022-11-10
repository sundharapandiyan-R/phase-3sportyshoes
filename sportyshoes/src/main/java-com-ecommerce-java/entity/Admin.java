package com.ecommerce.sportyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	/*
	 * create table admin( adminid VARCHAR(100) NOT NULL, adminmail VARCHAR(300) NOT
	 * NULL, adminpass VARCHAR(40) NOT NULL, PRIMARY KEY ( adminid ) );
	 * 
	 */

	@Id
	private String adminid;
	@Column
	private String adminmail;
	@Column
	private String adminpass;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminid, String adminmail, String adminpass) {
		super();
		this.adminid = adminid;
		this.adminmail = adminmail;
		this.adminpass = adminpass;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminmail() {
		return adminmail;
	}

	public void setAdminmail(String adminmail) {
		this.adminmail = adminmail;
	}

	public String getAdminpass() {
		return adminpass;
	}

	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminmail=" + adminmail + ", adminpass=" + adminpass + "]";
	}

}