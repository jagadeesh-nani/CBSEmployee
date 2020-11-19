package com.pack.cbs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.cbs.exception.ResourceNotFoundException;
import com.pack.cbs.model.Cart;
import com.pack.cbs.service.CartServices;

@RestController
@RequestMapping("/api/v2")
public class CartController { 
  
	@Autowired
	private CartServices cartservices;
	@GetMapping("/getAllProducts")
	public List<Cart> getAllProductsFromCart() {
		return cartservices.getAllProducts();
	}
	@PostMapping("/saveProduct")
	public Cart createProduct( @RequestBody Cart cartproduct) {
		return cartservices.saveProduct(cartproduct);
	}  
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Cart> getProductById(@PathVariable(value = "id") Integer productId) throws ResourceNotFoundException {
		Cart cart = cartservices.getProductById(productId);
		return  ResponseEntity.ok(cart);
	}
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Cart> updateProduct(@PathVariable(value = "id") Integer productId,
			 @RequestBody Cart product) throws ResourceNotFoundException {
		Cart companymanager = cartservices.updateProductById(productId, product);
		return  ResponseEntity.ok(companymanager);
	}

	@DeleteMapping("/deleteProduct/{id}")	
	public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id") Integer productId,@RequestBody Cart product) throws ResourceNotFoundException	{
		Boolean prod = cartservices.deleteProduct(productId);
		return  ResponseEntity.ok(prod);
	}
}
