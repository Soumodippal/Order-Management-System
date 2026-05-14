package com.example.dtomapper;

import java.util.List;

import com.example.dto.OrderItemResponseDto;
import com.example.model.OrderItem;

public class OrderItemResponseDtoMapper {
	
	public OrderItemResponseDto toDto(OrderItem item) {

	    OrderItemResponseDto dto = new OrderItemResponseDto();

	    dto.setFoodId(item.getFoodItem().getId());
	    dto.setFoodName(item.getFoodItem().getName());
	    dto.setQuantity(item.getQuantity());
	    dto.setPrice(item.getPrice());

	    return dto;
	}

}
