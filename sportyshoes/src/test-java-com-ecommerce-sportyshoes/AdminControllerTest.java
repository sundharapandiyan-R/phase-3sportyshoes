
package com.ecommerce.sportyshoes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.ecommerce.sportyshoes.controller.AdminController;
import com.ecommerce.sportyshoes.entity.Products;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.repository.ProductRepository;
import com.ecommerce.sportyshoes.repository.UserRepository;

//@WebMvcTest(value = AdminController.class) 
class AdminControllerTest extends AbstractTest {
/*
	@MockBean
	private UserRepository userRepository;

	@MockBean
	private ProductRepository productRepository;
	
	@MockBean
	private Products mockproduct;

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void viewAllRegisteredMembersTest() throws Exception {
		String uri = "/api/v1/admin/viewmembers";
		MvcResult mvcResult = mockmvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		User[] userlist = super.mapFromJson(content, User[].class);
		assertTrue(userlist.length > 0);
	}

	@Test
	public void createProduct() throws Exception {
		String URI = "/api/v1/admin/products";
		MvcResult mvcResult = null;
		//Products mockproduct = new Products();
		mockproduct.setProduct_id("PROD008");
		mockproduct.setProdname("Realme Narzo 11");
		mockproduct.setDescription("Realme Narzo 11 (black,128gb)");
		mockproduct.setBrand("Realme");
		mockproduct.setPrice(10999);
		mockproduct.setSize("16.6cm");
		mockproduct.setColor("Black");
		mockproduct.setDiscount(5);
		mockproduct.setProdcategory("Mobiles");
		mockproduct.setOrderid("");
		String inputJson = super.mapToJson(mockproduct);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		MockHttpServletResponse response = mvcResult.getResponse();
		assertThat(inputJson).isEqualTo(response);
	}
	*/
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	   
	@Test
	void testViewAllRegisteredMembers() {
		assertThat(this.restTemplate.getForEntity("http://localhost:"+port+"/api/v1/admin/viewmembers",User.class))
		.isNotNull();
	}

}