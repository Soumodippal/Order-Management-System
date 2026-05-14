package com.example.dto;

import java.math.BigDecimal;



import com.example.model.FoodItem;
import com.example.model.Order;


//public class OrderItemRequestDto {
//	   
//		private Long id;
//
//	    private Order order;
//
//	    private FoodItem foodItem;
//
//	    private int quantity;
//
//	    private BigDecimal price;
//
//		public OrderItemRequestDto() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//		public OrderItemRequestDto(Long id, Order order, FoodItem foodItem, int quantity, BigDecimal price) {
//			super();
//			this.id = id;
//			this.order = order;
//			this.foodItem = foodItem;
//			this.quantity = quantity;
//			this.price = price;
//		}
//
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public Order getOrder() {
//			return order;
//		}
//
//		public void setOrder(Order order) {
//			this.order = order;
//		}
//
//		public FoodItem getFoodItem() {
//			return foodItem;
//		}
//
//		public void setFoodItem(FoodItem foodItem) {
//			this.foodItem = foodItem;
//		}
//
//		public int getQuantity() {
//			return quantity;
//		}
//
//		public void setQuantity(int quantity) {
//			this.quantity = quantity;
//		}
//
//		public BigDecimal getPrice() {
//			return price;
//		}
//
//		public void setPrice(BigDecimal price) {
//			this.price = price;
//		}
//	    
//	    
//}


public class OrderItemRequestDto {
	
	
	private Long foodId;
	private int quantity;
	public OrderItemRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItemRequestDto(Long foodId, int quantity) {
		super();
		this.foodId = foodId;
		this.quantity = quantity;
	}
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}