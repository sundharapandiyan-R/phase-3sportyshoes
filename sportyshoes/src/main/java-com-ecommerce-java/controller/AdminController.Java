package com.ecommerce.sportyshoes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sportyshoes.entity.Admin;
import com.ecommerce.sportyshoes.entity.Orders;
import com.ecommerce.sportyshoes.entity.Products;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.exceptions.OrderNotFound;
import com.ecommerce.sportyshoes.exceptions.ProductNotFound;
import com.ecommerce.sportyshoes.exceptions.UserNotFound;
import com.ecommerce.sportyshoes.repository.AdminRepository;
import com.ecommerce.sportyshoes.repository.OrderRepository;
import com.ecommerce.sportyshoes.repository.ProductRepository;
import com.ecommerce.sportyshoes.repository.UserRepository;

@RestController

@RequestMapping("api/v1/admin")
public class AdminController {

	/*
	 * Sample JSON Format for user { "userid": 4, "username": "Prabhat", "userpass":
	 * "prabhat@123", "usermail": "prabhat.vish@gmail.com", "userphone": 9810750642,
	 * "address": "NOIDA", "pincode": 2986529 }
	 */

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private ProductRepository productrepository;

	@Autowired
	private OrderRepository orderrepository;

	@Autowired
	private AdminRepository adminrepository;

	// Admin Registration
	@PostMapping("/adminRegister")
	public Admin addAdmin(@RequestBody Admin admin) {
		return this.adminrepository.save(admin);
	}

	// Admin Feature 1: View All Users
	@GetMapping("/viewmembers")
	public List<User> viewAllRegisteredMembers() {
		return this.userrepository.findAll();
	}

	// Admin Feature 2: View a User by user ID
	@GetMapping("/searchuser/{id}")
	public User searchUser(@PathVariable(value = "id") int userId) {
		return this.userrepository.findById(userId)
				.orElseThrow(() -> new UserNotFound("Entered UserId Does'nt Exist : " + userId));
	}

	// Admin Feature 3: Admin will be able to view all products
	@GetMapping("/products")
	public List<Products> viewAllproducts() {
		return this.productrepository.findAll();
	}

	// Admin Feature 4: Admin will be able to view a product details by entering
	// product ID
	@GetMapping("/products/{id}")
	public Products viewProductById(@PathVariable(value = "id") String prodId) {
		return this.productrepository.findById(prodId)
				.orElseThrow(() -> new ProductNotFound("Product not found : " + prodId));

	}

	// Admin Feature 5: Admin will be able to view products filtered by product
	// category
	@GetMapping("/products/category/{category}")
	List<Products> viewProductsByCategory(@PathVariable(value = "category") String prodcategory) {
		List<Products> plist = this.productrepository.findAllByProdcategory(prodcategory);
		if (plist.isEmpty())
			throw new ProductNotFound("No Product of the category : " + prodcategory);
		else
			return plist;

	}

	// Admin Feature 5: Admin will be able to add products
	@PostMapping("/products")
	public Products addProduct(@RequestBody Products product) {
		return this.productrepository.save(product);
	}

	// Admin Feature 6: Admin will be able to modify product details
	@PutMapping("/products/{id}")
	public Products updateProduct(@RequestBody Products product, @PathVariable(value = "id") String prodId) {

		// 1. Find product
		Products fetchedProduct = this.productrepository.findById(prodId)
				.orElseThrow(() -> new ProductNotFound("Product not found : " + prodId));

		// 2. Set new values
		fetchedProduct.setProdname(product.getProdname());
		fetchedProduct.setDescription(product.getDescription());
		fetchedProduct.setBrand(product.getBrand());
		fetchedProduct.setPrice(product.getPrice());
		fetchedProduct.setSize(product.getSize());
		fetchedProduct.setColor(product.getColor());
		fetchedProduct.setDiscount(product.getDiscount());
		fetchedProduct.setProdcategory(product.getProdcategory());

		// 3. Save product
		return this.productrepository.save(fetchedProduct);
	}

	// Admin Feature 7: Admin will be able to delete product
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable(value = "id") String prodId) {
		// 1. Find product
		Products fetchedProduct = this.productrepository.findById(prodId)
				.orElseThrow(() -> new ProductNotFound("Product not found : " + prodId));
		this.productrepository.delete(fetchedProduct);

	}

	// Admin Feature 8: Admin will be able to view all the orders placed by customer
	@GetMapping("/getAllOrders")
	public List<Orders> viewAllPlacedOrders() {
		return this.orderrepository.findAll();
	}

	// Admin Feature 9: Admin will be able to view all orders placed on a particular
	// date
	// FETCHING DATA USING ANY OTHER FIELD THAN ID
	@GetMapping("/datefilter/{edate}")
	List<Orders> viewallOrdersByDate(@PathVariable(value = "edate") String edate) throws ParseException {
		Date convdate = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		List<Orders> ordlist = this.orderrepository.findAllByOrderdate(convdate);
		if (ordlist.isEmpty())
			throw new OrderNotFound("No orders placed on " + edate);
		else
			return ordlist;

	}

	// Admin Feature 10: Admin will be able to view all orders placed for a given
	// product category
	@GetMapping("/categoryfilter/{category}")
	List<Orders> viewallOrdersByProductCategory(@PathVariable(value = "category") String category) {
		List<Orders> ordlist = this.orderrepository.findAllByProds_Prodcategory(category);
		if (ordlist.isEmpty())
			throw new OrderNotFound("No orders placed for the category:  " + category);
		else
			return ordlist;

	}

}