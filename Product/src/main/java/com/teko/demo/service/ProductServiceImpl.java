package com.teko.demo.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.teko.demo.model.Product;
import com.teko.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    private ProductRepository productRepository;
	
//	@Override
//	public Iterable<Product> findAll() {
//		// TODO Auto-generated method stub
//		return productRepository.findAll();
//	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public Page<Product> listAllByPage(PageRequest pageRequest,int page, int size) {
		// TODO Auto-generated method stub
		return productRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Optional<Product> findOne(Integer id) {

		return productRepository.findById(id);
	}

	@Override
	public void save(Product contact) {
		// TODO Auto-generated method stub
		productRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}





	
}
