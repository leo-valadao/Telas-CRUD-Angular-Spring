package com.leonardo.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leonardo.Spring.domain.Customer;
import com.leonardo.Spring.domain.Product;
import com.leonardo.Spring.domain.Sale;
import com.leonardo.Spring.domain.SaleProduct;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Customer c1 = new Customer();
		c1.setName("John");
		c1.setEmail("John@email.com");

		Customer c2 = new Customer();
		c2.setName("Mike");
		c2.setEmail("Mike@email.com");

		Customer c3 = new Customer();
		c3.setName("Alex");
		c3.setEmail("Alex@email.com");

		Product p1 = new Product();
		p1.setName("Car");
		p1.setPrice(10000.00);

		Product p2 = new Product();
		p2.setName("House");
		p2.setPrice(100000.00);

		Product p3 = new Product();
		p3.setName("Bike");
		p3.setPrice(5000.00);

		Sale s1 = new Sale();
		s1.setCustomer(c1);

		SaleProduct sp1 = new SaleProduct();
		sp1.setProduct(p1);
		sp1.setSale(s1);
		
		System.out.println(sp1.getProduct());
		System.out.println(sp1.getSale());
	}
}
