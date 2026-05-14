package com.example.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.dto.OrderItemRequestDto;
import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.dtomapper.OrderItemRequestDtoMapper;
import com.example.dtomapper.OrderItemResponseDtoMapper;
import com.example.dtomapper.OrderRequestDtoMapper;
import com.example.dtomapper.OrderResponseDtoMapper;
import com.example.model.FoodItem;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.OrderStatus;
import com.example.model.User;
import com.example.repository.FoodItemRepository;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import com.example.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService{
	
	
	
	private OrderRepository orderRepository;
	private UserRepository userRepository;
	private OrderItemRepository orderItemRepository;
	private FoodItemRepository foodItemRepository;
	
	OrderRequestDtoMapper dtoMapper=new OrderRequestDtoMapper();
	OrderItemRequestDtoMapper dtoMapper2=new OrderItemRequestDtoMapper();
	
	OrderItemResponseDtoMapper dtoMapper3=new OrderItemResponseDtoMapper();
	OrderResponseDtoMapper dto=new OrderResponseDtoMapper();
	public OrderServiceImpl(OrderRepository orderRepository,UserRepository userRepository,OrderItemRepository orderItemRepository,FoodItemRepository foodItemRepository) {
		
		this.orderRepository=orderRepository;
		this.userRepository= userRepository;
		this.orderItemRepository = orderItemRepository;
		this.foodItemRepository=foodItemRepository;
	}

	
//	@Override
//	public Order createOrder(Order order) {
//		User user=userRepository.findById(order.getUser().getId()).orElse(null);
//		if(user!=null) {
//			order.setUser(user);
//			orderItemRepository.saveAll(order.getItems());
//			Order saveOrder=orderRepository.save(order);
//			orderRepository.flush(); 
//			return saveOrder;
//		}
//		
//		return null;
//	}

	@Override
	public OrderResponseDto createOrder(OrderRequestDto order) {
		
		User user=userRepository.findById(order.getUserId()).orElseThrow(()->new RuntimeException());
		
		Order order2=new Order();
		order2.setStatus(OrderStatus.PENDING);
		order2.setCreatedAt(LocalDateTime.now());
		
		BigDecimal price=BigDecimal.ZERO;
		if(user!=null) {
			order2.setUser(user);
			List<OrderItem> allorditem=new ArrayList<>();
			for(OrderItemRequestDto orditem : order.getOrderItems()) {
				System.out.println("Food ID = " + orditem.getFoodId());
				FoodItem fd=foodItemRepository.findById(orditem.getFoodId()).orElseThrow(()-> new RuntimeException());
				
					OrderItem item=new OrderItem();
					item.setQuantity(orditem.getQuantity());
					item.setFoodItem(fd);
					item.setPrice(fd.getPrice().multiply(BigDecimal.valueOf(orditem.getQuantity())));
					item.setOrder(order2);
					
					price=price.add(item.getPrice());
					allorditem.add(item);
			}
			
			order2.setOrderitems(allorditem);
			order2.setTotalPrice(price);
			Order saveOrder=orderRepository.save(order2);
			orderRepository.flush();
			
			return dto.toDto(saveOrder);
		}
		
		return null;
	}
	@Override
	public OrderResponseDto getById(Long id) {
		Order or=orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order doesn't exists at this ID"));
		return dto.toDto(or);
	}

	@Override
	public List<OrderResponseDto> getAll() {
	    List<Order> orders = orderRepository.findAll();
	    
	    List<OrderResponseDto> ord2=orders.stream().map(order-> dto.toDto(order)).collect(Collectors.toList());


	    return ord2;
	}
	
	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public OrderResponseDto updateById(Long id,OrderRequestDto or) {
		Order order=orderRepository.findById(id).orElseThrow(()-> new RuntimeException());
		
			User user=userRepository.findById(or.getUserId()).orElseThrow(()->new RuntimeException());
			if(user!=null && or.getOrderItems()!=null) {
				
				List<OrderItem> allOrditem=new ArrayList<>();
				BigDecimal price=BigDecimal.ZERO;
				
				for(OrderItemRequestDto ord : or.getOrderItems()) {
					OrderItem item=new OrderItem();
					FoodItem foodItem=foodItemRepository.findById(ord.getFoodId()).orElseThrow(()->new RuntimeException());
					
						item.setQuantity(ord.getQuantity());
						item.setFoodItem(foodItem);
						item.setPrice(foodItem.getPrice().multiply(BigDecimal.valueOf(ord.getQuantity())));
						
						item.setOrder(order);
						price=price.add(item.getPrice());
						
						allOrditem.add(item);
						
					
			}
				order.setOrderitems(allOrditem);
				order.setTotalPrice(price);
				order.setCreatedAt(LocalDateTime.now());
				Order saveorder=orderRepository.save(order);
				OrderResponseDto ordRq=dto.toDto(saveorder);
				return ordRq;
			
	}
			return null;
	}


			
	}

