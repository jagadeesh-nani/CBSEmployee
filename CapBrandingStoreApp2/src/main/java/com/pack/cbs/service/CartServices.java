package com.pack.cbs.service;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pack.cbs.dao.CartRepository;
import com.pack.cbs.exception.ResourceNotFoundException;
import com.pack.cbs.model.Cart;


/** The CartService class provides access to repository methods to CRUD operations Cart details 
 * 
 * 
 * @author Reshma's
 *
 */


@Service
public class CartServices implements ICartServices {
	private static final Logger logger = LogManager.getLogger(CartServices.class);
	
	@Autowired
	private CartRepository cartrepository;
	
	public Cart getProductById(Integer productId)
			throws ResourceNotFoundException {
		Cart cart = cartrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id ::" + productId));
		 logger.info(" Retrieved products by id successfully...!");
		return cart;
	}
	
	
	 public boolean deleteProduct(Integer productId)
				throws ResourceNotFoundException {
		 Cart cart = cartrepository.findById(productId)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		 cartrepository.delete(cart);
		 if(null == cart){
	            return true;
	        }
		 logger.info("Deleted products successfully...!");   
		 return false;
	}
	 
	 public Cart updateProductById(Integer productId,Cart product) throws ResourceNotFoundException {
		 Cart cart = cartrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		 cart.setProductName(product.getProductName());
		 cart.setProductPrice(product.getProductPrice());
		 cart.setQuantity(product.getQuantity());
		final Cart updatedproduct = cartrepository.save(cart);
		logger.info("Updated products successfully...!"); 
		return updatedproduct; 
		
	}
	 public List<Cart> getAllProducts() {  
		 logger.info(" Retrieved products successfully...!");	
		 return cartrepository.findAll();
		}
		 
		 public Cart saveProduct(Cart product) {
			 logger.info("Product Added to cart Successfully...!");
			 return  cartrepository.save(product);
			  
			
		}

}
