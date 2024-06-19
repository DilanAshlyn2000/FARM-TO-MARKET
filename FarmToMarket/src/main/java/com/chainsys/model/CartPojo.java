package com.chainsys.model;


public class CartPojo {
	int cartId;
	  int  customerId;
		
	    int productId;
	    int quantity;
	    float unitPrice;
	    float total;
	    ProductPojo product;
	    Float bill;
	
		public float getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(float unitPrice) {
			this.unitPrice = unitPrice;
		}
		public int getCartId() {
			return cartId;
		}
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public float getTotal() {
			return total;
		}
		public void setTotal(float total) {
			this.total = total;
		}
		public ProductPojo getProduct() {
			return product;
		}
		public void setProduct(ProductPojo product) {
			this.product = product;
		}
		public Float getBill() {
			return bill;
		}
		public void setBill(Float bill) {
			this.bill = bill;
		}
		
	
}
