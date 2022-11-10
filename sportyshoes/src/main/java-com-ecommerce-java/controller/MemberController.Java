package com.ecommerce.sportyshoes.controller;

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
import com.ecommerce.sportyshoes.entity.Orders;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.exceptions.OrderNotFound;
import com.ecommerce.sportyshoes.exceptions.UserNotFound;
import com.ecommerce.sportyshoes.repository.OrderRepository;
import com.ecommerce.sportyshoes.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private OrderRepository orderrepository;

	//Customer Feature 1: Add new User --> User Registration
	@PostMapping("/register")
	public User memberRegistration(@RequestBody User user) {
		return this.userrepository.save(user);
	}

	//Customer Feature 2: Update/Modify User details	
	@PutMapping("/update/{id}")
	public User updateMemberDetails(@RequestBody User user, @PathVariable(value = "id") int userId) {

		// 1. Find product
		User fetchedUser = this.userrepository.findById(userId)
				.orElseThrow(() -> new UserNotFound("User not found : " + userId));

		// 2. Set new values fetchedUser.setUsername(user.getUsername());
		fetchedUser.setUserpass(user.getUserpass());
		fetchedUser.setUsermail(user.getUsermail());
		fetchedUser.setUserphone(user.getUserphone());
		fetchedUser.setAddress(user.getAddress());
		fetchedUser.setPincode(user.getPincode());

		// 3. Save product
		return this.userrepository.save(fetchedUser);
	}

	//Customer Feature 3: Delete User account
	@DeleteMapping("/delete/{id}")
	public void deleteMemberAccount(@PathVariable(value = "id") int userId) {
		// 1. Find product
		User fetchedUser = this.userrepository.findById(userId)
				.orElseThrow(() -> new UserNotFound("User not found : " + userId));
		this.userrepository.delete(fetchedUser);

	}

	//Customer Feature 4: User will be able to purchase products
	@PostMapping("/placeorder")
	public Orders purchaseProducts(@RequestBody Orders order) {
		return this.orderrepository.save(order);

	}

	/*
	 * FETCHING DATA USING FOREIGN KEY findBy + (the foreign key member of ORDER
	 * class with first letter Upper) + underscore +the data member of USER Class
	 * with first letter UpperCase +(int userid);
	 */
	//Customer Feature 5 : User will be able to view all placed order based on userid.
	@GetMapping("/searchOrder/{userid}")
	List<Orders> viewplacedOrder(@PathVariable(value = "userid") int userid) {
		List<Orders> ordlist = this.orderrepository.findAllByUsers_Userid(userid);
		if (ordlist.isEmpty())
			throw new OrderNotFound("No orders placed by user " + userid);
		else
			return ordlist;

	}

}