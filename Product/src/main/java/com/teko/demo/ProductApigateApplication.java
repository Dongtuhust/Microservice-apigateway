package com.teko.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.teko.demo.model.Product;
import com.teko.demo.service.ProductService;
import com.teko.demo.service.ProductServiceImpl;

import java.util.Date;
import java.util.Random;
@SpringBootApplication
//@EnableDiscoveryClient
public class ProductApigateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApigateApplication.class, args);
//		ProductServiceImpl productService = new ProductServiceImpl();
//		for(int i=0;i<100;i++) {
//			Faker faker = new Faker();
//			String title = faker.book().title();
//			String sku = faker.ancient().hero();
//			int price = rand(50000,200000);
//			String attb = faker.book().author();
//			String brand = faker.company().logo();
//			String category = faker.book().genre();
//			Date today=new Date(System.currentTimeMillis());
//			String createAt = faker.date().toString();
////			productService.save(product);
////			System.out.println(product.getAttibute());
//		}
	}
//	 public static int rand(int min, int max) {
//	        try {
//	            Random rn = new Random();
//	            int range = max - min + 1;
//	            int randomNum = min + rn.nextInt(range);
//	            return randomNum;
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return -1;
//	        }
//	    }
}
