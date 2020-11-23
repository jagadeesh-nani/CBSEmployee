package com.pack.cbs.model;


/** This is an entity class for Cart module with getters, setters
 * 
 * @author Reshma's
 *
 */
    import io.swagger.annotations.ApiModelProperty;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

		@Entity
		@Table(name="Shopping_cart")
		public class Cart {
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    @ApiModelProperty(notes = "Product Id",name="productId",required=true,value="test productId")
	    @Column(name="product_id")
		private Integer productId;
	    @ApiModelProperty(notes = "Product Name",name="productName",required=true,value="test productName")
        @Column(name="product_name",nullable = false)
		private String productName;
		@Column(name="product_price",nullable = false)
		 @ApiModelProperty(notes = "Product Price",name="productPrice",required=true,value="test productPrice")
		private double productPrice;
		@Column(name="product_quantity",nullable = false)
		 @ApiModelProperty(notes = "Product Quantity",name="quantity",required=true,value="test quantity")
		private int quantity;
		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
}
