package com.gk.repository.prod;

import org.springframework.data.repository.CrudRepository;

import com.gk.entity.prod.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

}
