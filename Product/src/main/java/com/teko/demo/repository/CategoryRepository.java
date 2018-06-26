package com.teko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teko.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
