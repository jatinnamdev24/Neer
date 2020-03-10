package com.tr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tr.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> getProductsByCategory(String category);
	@Query("select p from Product p where price between ?1 and ?2")
	List<Product> getProductsByRange(double min,double max);
}
