package com.teko.demo.controller;
import java.util.Date;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teko.demo.model.Category;
import com.teko.demo.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
@Api(value="Category")
public class CategoryController {
	@Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "View a list of available Category",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<Category> list(Model model){
        Iterable<Category> CategoryList = categoryService.findAll();
        return CategoryList;
    }
    
    @ApiOperation(value = "Search a Category with an ID",response = Category.class)
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    public Category showCategory(@PathVariable Integer id, Model model){
       Category category = categoryService.findOne(id);
        return category;
    }
    
    @ApiOperation(value = "Add a category")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public void saveCategory (@RequestBody Category category){
        categoryService.save(category);
    }
    
    @ApiOperation(value = "Update a category")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public void updateCategory(@PathVariable Integer id, @RequestBody Category Category){
        Category storedCategory = categoryService.findOne(id);
        storedCategory.setName(Category.getName());
        Date today=new Date(System.currentTimeMillis());
        storedCategory.setModijedAt(today);
        storedCategory.setCreateAt(today);
        categoryService.save(storedCategory);
    }

    @ApiOperation(value = "Delete a Category")
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Integer id){
        categoryService.delete(id);
    }
	
}