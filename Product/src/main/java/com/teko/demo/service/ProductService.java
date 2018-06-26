package com.teko.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.teko.demo.model.Product;

public interface ProductService {
	
	Page<Product> listAllByPage(PageRequest pageRequest,int page, int size);

    Optional<Product> findOne(Integer id);

    void save(Product contact);

    void delete(int id);

}
