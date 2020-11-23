package com.pack.cbs.controller;

/** This is a Controller class for Cart module 
 * 
 * @author Reshma's
 *
 */

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "CartController", description = "REST Apis related to Cart Entity!!!!")
@RestController
@RequestMapping("/api/v2")
public class CartController { 
	private static final Logger logger = LogManager.getLogger(CartController.class);
	@Autowired
	private CartServices cartservices;
	
	/** 
	 * 
	 *This method returns the list of products details in cart 
	 * 
	 * 
	 */
	
	
	@ApiOperation(value = "Get list of Product in the cart ", response = Iterable.class, tags = "CartController")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	
	@GetMapping("/getAllProducts")
	public List<Cart> getAllProductsFromCart() {
		 logger.info(" Retrieved all products successfully...!");
		return cartservices.getAllProducts();
	}
	
	/** This method adds the product details 
	 * 
	 * @param Cart entity details
	 * 
	 * 
	 */
	
	
	@ApiOperation(value = "Get list of Product in the cart ", response = Iterable.class, tags = "CartController")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	
	
	@PostMapping("/saveProduct")
	public Cart createProduct( @RequestBody Cart cartproduct) {
		logger.info("Product Added to cart Successfully...!");
		return cartservices.saveProduct(cartproduct);
	}  
	
	/** 
	 * 
	 *This method returns the list of product details in cart
	 * @param Cart - productId 
	 * 
	 */
	
	
	
	@ApiOperation(value = "Get list of Product in the cart By Id ", response = Iterable.class, tags = "CartController")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Cart> getProductById(@PathVariable(value = "id") Integer productId) throws ResourceNotFoundException {
		Cart cart = cartservices.getProductById(productId);
		 logger.info(" Retrieved all products successfully...!");
		return  ResponseEntity.ok(cart);
	}
	
	
	/** This method updates the product details 
	 * 
	 * @param Cart entity details and Cart - productId
	 * 
	 * 
	 */
	
	
	
	
	@ApiOperation(value = "Update Product in the cart by Id ", response = Iterable.class, tags = "CartController")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Cart> updateProduct(@PathVariable(value = "id") Integer productId,
			 @RequestBody Cart product) throws ResourceNotFoundException {
		Cart companymanager = cartservices.updateProductById(productId, product);
		logger.info("Updated products successfully...!");
		return  ResponseEntity.ok(companymanager);
	}

	
	/** This method deletes the product details 
	 * 
	 * @param Cart entity details and Cart - productId
	 * 
	 * 
	 */
	
	
	
	@ApiOperation(value = "Delete Product in the cart ", response = Iterable.class, tags = "CartController")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	
	
	@DeleteMapping("/deleteProduct/{id}")	
	public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id") Integer productId,@RequestBody Cart product) throws ResourceNotFoundException	{
		Boolean prod = cartservices.deleteProduct(productId);
		logger.info("Deleted products successfully...!");
		return  ResponseEntity.ok(prod);
	}
}
