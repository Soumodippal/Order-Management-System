package com.example.dtomapper;

import com.example.dto.OrderItemRequestDto;
import com.example.model.OrderItem;

public class OrderItemRequestDtoMapper {
	public OrderItemRequestDto toDto(OrderItem order) {
		
		return new OrderItemRequestDto(order.getFoodItem().getId(),order.getQuantity());
	}
	
//	public OrderItem toEntity(OrderItemRequestDto order) {
//		return new OrderItem(order.getId(),order.getOrder(),order.getFoodItem(),order.getQuantity(),order.getPrice());
//	}
}
