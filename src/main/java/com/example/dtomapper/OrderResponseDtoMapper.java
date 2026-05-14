package com.example.dtomapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.OrderItemRequestDto;
import com.example.dto.OrderItemResponseDto;
import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.OrderStatus;

public class OrderResponseDtoMapper {
	private OrderItemResponseDtoMapper dtoMapper=new OrderItemResponseDtoMapper();
	public OrderResponseDto toDto(Order order) {
		List<OrderItem> allitems=new ArrayList<>();
		allitems.addAll(order.getOrderitems());
		List<OrderItemResponseDto> items=new ArrayList<>();
		for(OrderItem dto:allitems) {
			items.add(dtoMapper.toDto(dto));
		}
		return new OrderResponseDto(order.getId(),order.getUser().getId(),order.getTotalPrice(),
				order.getStatus(),order.getCreatedAt(),items);
	}


}