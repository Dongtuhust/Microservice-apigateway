package com.teko.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teko.demo.model.Category;
import com.teko.demo.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Override
	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

//	@Override
//	public List<Product> search(String q) {
//		// TODO Auto-generated method stub
//		return productRepository.findByNameContaining(q);
//	}

	@Override
	public Category findOne(Integer id) {
		// TODO Auto-generated method stub
		return categoryRepository.getOne(id);
	}

	@Override
	public void save(Category contact) {
		// TODO Auto-generated method stub
		categoryRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
		
	}
}
