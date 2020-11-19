package com.pack.cbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.cbs.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
