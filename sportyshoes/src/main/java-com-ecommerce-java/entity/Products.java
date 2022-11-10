package com.ecommerce.sportyshoes.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*create table products(
productid VARCHAR(200) NOT NULL,
prodname VARCHAR(100) NOT NULL,
description VARCHAR(100) NOT NULL,
brand VARCHAR(40) NOT NULL,
price INT NOT NULL,
size VARCHAR(100) NOT NULL,
color VARCHAR(300) NOT NULL,
discount INT NOT NULL,
   PRIMARY KEY ( productid )
);*/

@Entity
@Table(name = "products")
public class Products {

	@Id
	private String product_id;
	private String prodname;
	private String description;
	private String brand;
	private int price;
	private String size;
	private String color;
	private int discount;
	private String prodcategory;
	private String orderid;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(String product_id, String prodname, String description, String brand, int price, String size,
			String color, int discount, String prodcategory) {
		super();
		this.product_id = product_id;
		this.prodname = prodname;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.color = color;
		this.discount = discount;
		this.prodcategory = prodcategory;
	}

	public Products(String product_id, String prodname, String description, String brand, int price, String size,
			String color, int discount, String prodcategory, String orderid) {
		super();
		this.product_id = product_id;
		this.prodname = prodname;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.color = color;
		this.discount = discount;
		this.prodcategory = prodcategory;
		this.orderid = orderid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getProdcategory() {
		return prodcategory;
	}

	public void setProdcategory(String prodcategory) {
		this.prodcategory = prodcategory;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", prodname=" + prodname + ", description=" + description
				+ ", brand=" + brand + ", price=" + price + ", size=" + size + ", color=" + color + ", discount="
				+ discount + ", prodcategory=" + prodcategory + ", orderid=" + orderid + "]";
	}

}