
package com.ecommerce.sportyshoes.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
create table orders(
orderid VARCHAR(200) NOT NULL,
ordertotal INT NOT NULL,
orderdate DATE NOT NULL,
userid INT NOT NULL,
PRIMARY KEY ( orderid ),
FOREIGN KEY (userid) REFERENCES user(userid)
);
*/

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	private String orderid;
	@Column
	private int ordertotal;
	@Column
	private Date orderdate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userid")
	private User users;

	@OneToMany
	@JoinColumn(name = "orderid", referencedColumnName = "orderid")
	private List<Products> prods;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderid, int ordertotal, Date orderdate, User users, List<Products> prods) {
		super();
		this.orderid = orderid;
		this.ordertotal = ordertotal;
		this.orderdate = orderdate;
		this.users = users;
		this.prods = prods;
	}

	public List<Products> getProds() {
		return prods;
	}

	public void setProds(List<Products> prods) {
		this.prods = prods;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public int getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(int ordertotal) {
		this.ordertotal = ordertotal;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", ordertotal=" + ordertotal + ", orderdate=" + orderdate + ", users="
				+ users + ", prods=" + prods + "]";
	}
}