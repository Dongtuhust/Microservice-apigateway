package com.teko.demo.service;

import com.teko.demo.model.Category;

public interface CategoryService {
	Iterable<Category> findAll();

	Category findOne(Integer id);

	void save(Category contact);

	void delete(int id);
}
