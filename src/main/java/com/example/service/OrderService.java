package com.example.service;

import java.util.List;

import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.model.Order;


public interface OrderService {
	
	public OrderResponseDto createOrder(OrderRequestDto order);
	
	public OrderResponseDto getById(Long id);
	
	public List<OrderResponseDto> getAll();
	
	public void deleteById(Long id);
	
	public OrderResponseDto updateById(Long id,OrderRequestDto or);
	
}
