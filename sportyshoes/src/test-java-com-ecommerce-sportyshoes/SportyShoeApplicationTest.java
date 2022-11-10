
package com.ecommerce.sportyshoes;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.ecommerce.sportyshoes.controller.AdminController;
import com.ecommerce.sportyshoes.entity.Products;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SportyshoesApplicationTests {

	@Autowired
	private AdminController adminController;

	@MockBean
	private Products prod;

	@Test
	void contextLoads() {
		assertThat(adminController).isNotNull();
		assertThat(prod).isNotNull();
	}

}