package com.example.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.model.OrderStatus;
import com.example.model.User;

public class OrderResponseDto {
	
	private Long orderId;
	private Long userId;
	private BigDecimal totalPrice;
	private OrderStatus status;
	private LocalDateTime createdAt;
	private List<OrderItemResponseDto> items;
	public OrderResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderResponseDto(Long orderId, Long userId, BigDecimal totalPrice, OrderStatus status,
			LocalDateTime createdAt, List<OrderItemResponseDto> items) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdAt = createdAt;
		this.items = items;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<OrderItemResponseDto> getItems() {
		return items;
	}
	public void setItems(List<OrderItemResponseDto> items) {
		this.items = items;
	}
	
	
	
}
