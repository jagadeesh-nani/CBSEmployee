package com.pack.cbs.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pack.cbs.dao.CartRepository;
import com.pack.cbs.exception.ResourceNotFoundException;
import com.pack.cbs.model.Cart;

@Service
public class CartServices implements ICartServices {
	
	@Autowired
	private CartRepository cartrepository;
	
	public Cart getProductById(Integer productId)
			throws ResourceNotFoundException {
		Cart cart = cartrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
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
	        return false;
	}
	 
	 public Cart updateProductById(Integer productId,Cart product) throws ResourceNotFoundException {
		 Cart cart = cartrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		 cart.setProductName(product.getProductName());
		 cart.setProductPrice(product.getProductPrice());
		 cart.setQuantity(product.getQuantity());
		final Cart updatedproduct = cartrepository.save(cart);
		return updatedproduct; 
		
	}
	 public List<Cart> getAllProducts() {  
			return cartrepository.findAll();
		}
		 
		 public Cart saveProduct(Cart product) {
			return  cartrepository.save(product);
			  
			
		}

}
