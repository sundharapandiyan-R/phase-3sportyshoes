
package com.ecommerce.sportyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*create table user(
		userid INT NOT NULL AUTO_INCREMENT,
		username VARCHAR(100) NOT NULL,
		userpass VARCHAR(40) NOT NULL,
		usermail VARCHAR(100) NOT NULL,
		userphone INT NOT NULL,
		address VARCHAR(300) NOT NULL,
		pincode INT NOT NULL,
		   PRIMARY KEY ( userid )
		);*/
@Table
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@Column
	private String username;
	@Column
	private String userpass;
	@Column
	private String usermail;
	@Column
	private long userphone;
	@Column
	private String address;
	@Column
	private long pincode;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String userpass, String usermail, long userphone, String address, long pincode) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.usermail = usermail;
		this.userphone = userphone;
		this.address = address;
		this.pincode = pincode;
	}

	public User(int userid, String username, String userpass, String usermail, long userphone, String address,
			long pincode) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.usermail = usermail;
		this.userphone = userphone;
		this.address = address;
		this.pincode = pincode;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public long getUserphone() {
		return userphone;
	}

	public void setUserphone(long userphone) {
		this.userphone = userphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userpass=" + userpass + ", usermail=" + usermail
				+ ", userphone=" + userphone + ", address=" + address + ", pincode=" + pincode + "]";
	}

}