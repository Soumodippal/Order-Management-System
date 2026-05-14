package com.example.dtomapper;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.OrderItemRequestDto;
import com.example.dto.OrderRequestDto;
import com.example.model.Order;
import com.example.model.OrderItem;

//public class OrderRequestDtoMapper {
//	
//	private OrderItemRequestDtoMapper dtoMapper=new OrderItemRequestDtoMapper();
//	
//	public OrderRequestDto toDto(Order order) {
//		List<OrderItem> allItems=new ArrayList<>();
//		allItems.addAll(order.getOrderitems());
//		List<OrderItemRequestDto> items=new ArrayList<>();
//		for(OrderItem dto: allItems) {
//			items.add(dtoMapper.toDto(dto));
//		}
//		return new OrderRequestDto(order.getId(),order.getUser(),order.getStatus(),order.getTotalPrice(),order.getCreatedAt(),items);
//	}
//	
//	public Order toEntity(OrderRequestDto order) {
//		List<OrderItemRequestDto> allItems=new ArrayList<>();
//		allItems.addAll(order.getOrderitems());
//		List<OrderItem> items=new ArrayList<>();
//		for(OrderItemRequestDto dto: allItems) {
//			items.add(dtoMapper.toEntity(dto));
//		}
//		
//		return new Order(order.getId(),order.getUser(),order.getStatus(),order.getTotalPrice(),order.getCreatedAt(),items);
//	}
//}

public class OrderRequestDtoMapper {
	
	private OrderItemRequestDtoMapper dtoMapper=new OrderItemRequestDtoMapper();
	
	public OrderRequestDto toDto(Order order) {
		List<OrderItem> allItems=new ArrayList<>();
		allItems.addAll(order.getOrderitems());
		List<OrderItemRequestDto> items=new ArrayList<>();
		for(OrderItem dto: allItems) {
			items.add(dtoMapper.toDto(dto));
		}
		return new OrderRequestDto(order.getId(),items);
	}
	
//	public Order toEntity(OrderRequestDto order) {
//		// userid
//		//orderitems
//		//created
//		List<OrderItemRequestDto> allItems=new ArrayList<>();
//		allItems.addAll(order.getOrderItems());
//		List<OrderItem> items=new ArrayList<>();
//		for(OrderItemRequestDto dto: allItems) {
//			items.add(dtoMapper.toEntity(dto));
//		}
//		
//		return new Order(order.getUserId() ,order.getCreatedAt(),items);
//	}
}
