package com.cg.sprint1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint1.entity.Product;

public interface IProductDao extends JpaRepository<Product, Integer>{

}
