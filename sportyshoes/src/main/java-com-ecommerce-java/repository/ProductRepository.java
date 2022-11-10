
package com.ecommerce.sportyshoes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.sportyshoes.entity.Products;

public interface ProductRepository extends JpaRepository<Products, String> {

	List<Products> findAllByProdcategory(String prodcategory);

}