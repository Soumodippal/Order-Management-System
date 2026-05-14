package com.example.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.model.OrderItem;
import com.example.model.OrderStatus;
import com.example.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;


//public class OrderRequestDto {
//		
//		private Long id;
//	    private User user;
//	    
//	    @Enumerated(EnumType.STRING)
//	    private OrderStatus status;
//
//	    private BigDecimal totalPrice;
//
//	   
//	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	    private LocalDateTime createdAt;
//	    
//	    private List<OrderItemRequestDto> orderitems;
//
//		public OrderRequestDto() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//		public OrderRequestDto(Long id, User user, OrderStatus status, BigDecimal totalPrice, LocalDateTime createdAt,
//				List<OrderItemRequestDto> orderitems) {
//			super();
//			this.id = id;
//			this.user = user;
//			this.status = status;
//			this.totalPrice = totalPrice;
//			this.createdAt = createdAt;
//			this.orderitems = orderitems;
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
//		public User getUser() {
//			return user;
//		}
//
//		public void setUser(User user) {
//			this.user = user;
//		}
//
//		public OrderStatus getStatus() {
//			return status;
//		}
//
//		public void setStatus(OrderStatus status) {
//			this.status = status;
//		}
//
//		public BigDecimal getTotalPrice() {
//			return totalPrice;
//		}
//
//		public void setTotalPrice(BigDecimal totalPrice) {
//			this.totalPrice = totalPrice;
//		}
//
//		public LocalDateTime getCreatedAt() {
//			return createdAt;
//		}
//
//		public void setCreatedAt(LocalDateTime createdAt) {
//			this.createdAt = createdAt;
//		}
//
//		public List<OrderItemRequestDto> getOrderitems() {
//			return orderitems;
//		}
//
//		public void setOrderitems(List<OrderItemRequestDto> orderitems) {
//			this.orderitems = orderitems;
//		}
//
//		
//}

public class OrderRequestDto {
	
	private Long userId;
	private List<OrderItemRequestDto> orderItems;
	

	public OrderRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequestDto(Long userId, List<OrderItemRequestDto> orderItems) {
		super();
		this.userId = userId;
		this.orderItems = orderItems;
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<OrderItemRequestDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemRequestDto> orderItems) {
		this.orderItems = orderItems;
	}

	

}