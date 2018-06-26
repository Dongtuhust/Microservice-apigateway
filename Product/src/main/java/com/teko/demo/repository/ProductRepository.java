package com.teko.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.teko.demo.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{

}
