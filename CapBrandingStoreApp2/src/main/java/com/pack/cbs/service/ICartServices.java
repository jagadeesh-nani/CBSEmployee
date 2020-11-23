package com.pack.cbs.service;

import java.util.List;
import com.pack.cbs.exception.ResourceNotFoundException;
import com.pack.cbs.model.Cart;

/** This is an interface which defines CRUD methods for Cart service
 * 
 * @author Reshma's
 *
 */


public interface ICartServices {
	 public List<Cart> getAllProducts();
	 public Cart saveProduct(Cart product);
	 public Cart updateProductById(Integer productId,Cart product) throws ResourceNotFoundException;
	 public boolean deleteProduct(Integer productId) throws ResourceNotFoundException;
	 public Cart getProductById(Integer productId) throws ResourceNotFoundException;
}
