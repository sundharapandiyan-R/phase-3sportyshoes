package com.ecommerce.sportyshoes.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.sportyshoes.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, String> {

	List<Orders> findAllByOrderdate(Date convdate);

	List<Orders> findAllByUsers_Userid(int userid);

	List<Orders> findAllByProds_Prodcategory(String category);
}