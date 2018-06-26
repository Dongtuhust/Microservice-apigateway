package com.teko.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.teko.demo.model.Product;
import com.teko.demo.service.ProductService;

@RestController
@Api(value="product")
@RequestMapping(value = "/products")
public class ProductController {
	@Autowired
    private ProductService productService;

    @ApiOperation(value = "View a list of available product",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET, produces = "application/json")
    public  Page<Product> list(@PathVariable int page,@PathVariable int size,Model model){
        @SuppressWarnings("deprecation")
        PageRequest pageRequest = new PageRequest(page,size);
		Page<Product> productList = productService.listAllByPage(pageRequest,page,size);
        return  productList;
    }
    
    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    public Optional<Product> showProduct(@PathVariable Integer id, Model model){
       Optional<Product> product = productService.findOne(id);
        return product;
    }
    
    @ApiOperation(value = "Add a product")
    @RequestMapping( method = RequestMethod.POST, produces = "application/json")
    public void saveProduct(@RequestBody Product product){
        productService.save(product);
        String[] Sizes = {"S","M","XS","XM","L","XL","XXL"};
        String[] materials = {"iron","gold","silver","aluminum","plastic","copper","inoc"};
        String[] categorys = {"Action","Romatic","Comedy","Adventure","Drama","Horror","Mucicals"};
		for(int i=0;i<10;i++) {
		Faker faker = new Faker();
		String title = faker.book().title();
		String sku = faker.ancient().hero();
		int price = rand(50000,200000);
		Map<String,String> attb = new HashMap<>();
		int r = rand(0,6);
		attb.put("Size", Sizes[r]);
		int ran = rand(1,10);
		String weight= String.valueOf(ran) + " kg";
		attb.put("Weight", weight);
		int r2 = rand(0,6);
		attb.put("Material", materials[r2]);
		String color = faker.color().name();
		attb.put("Color", color);
		String brand = faker.company().logo();
		String category = categorys[r];
		Date today=new Date(System.currentTimeMillis());
		String createAt = faker.date().toString();
		Product product2 = new Product(sku, title, price, category,today, today, attb, brand);
		productService.save(product2);
		}
    }
	 public static int rand(int min, int max) {
    try {
        Random rn = new Random();
        int range = max - min + 1;
        int randomNum = min + rn.nextInt(range);
        return randomNum;
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}
    
    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Optional<Product> storedProduct = productService.findOne(id);
        if (! storedProduct.isPresent()) {
        	//
        }
        Product p = storedProduct.get();
        p.setSku(product.getSku());
        p.setTitle(product.getTitle());
        p.setCategory(product.getCategory());
        Date today=new Date(System.currentTimeMillis());
        p.setModijedAt(today);
        p.setPrice(product.getPrice());
        p.setAttibute(product.getAttibute());
        p.setBrand(product.getBrand());
        productService.save(p);
    }

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
	
}