//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.dto.OrderRequestDto;
//import com.example.model.Order;
//import com.example.service.OrderService;
//
//@RestController
//@RequestMapping("/order")
//public class OrderController {
//	
//	private OrderService orderService;
//	
//	public OrderController(OrderService orderService) {
//		this.orderService=orderService;
//	}
//	
//	@PostMapping
//	public ResponseEntity<OrderRequestDto> createOrder(@RequestBody OrderRequestDto order) {
//		OrderRequestDto or=orderService.createOrder(order);
//		return new ResponseEntity<OrderRequestDto>(or,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id) {
//		OrderRequestDto order=orderService.getById(id);
//		return ResponseEntity.ok(order);
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<OrderRequestDto>>  getAll(){
//		return  ResponseEntity.status(HttpStatus.OK).body(orderService.getAll());
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteById(@PathVariable Long id) {
//		orderService.deleteById(id);
//		return new ResponseEntity<String>("Delected successfull",HttpStatus.OK);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<OrderRequestDto> updateUserById(@PathVariable Long id,@RequestBody OrderRequestDto or) {
//		OrderRequestDto or2=orderService.updateById(id, or);
//		return new ResponseEntity<OrderRequestDto>(or2,HttpStatus.OK);
//	}
//}

package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.OrderItemRequestDto;
import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.model.FoodItem;
import com.example.model.Order;
import com.example.service.FoodService;
import com.example.service.OrderService;

@Controller
@RequestMapping("/order-page")
public class OrderController {
	
	private OrderService orderService;
	private FoodService foodService;
	
	public OrderController(OrderService orderService,FoodService foodService) {
		this.orderService=orderService;
		this.foodService=foodService;
	}
	
	@GetMapping("/order")
	public String getOrder(@RequestParam Long foodId,Model model) {
		
		FoodItem food=foodService.getById(foodId);
		model.addAttribute("food",food);
	
		return "order";
	}
	
	
	@PostMapping("/place-order")
	public String createOrder(
	        @RequestParam("foodId") Long foodId,
	        @RequestParam("userId") Long userId,
	        @RequestParam("quantity") int quantity,
	        RedirectAttributes ra) {

	    OrderItemRequestDto item = new OrderItemRequestDto();
	    item.setFoodId(foodId);
	    item.setQuantity(quantity);

	    List<OrderItemRequestDto> items = new ArrayList<>();
	    items.add(item);

	    OrderRequestDto dto = new OrderRequestDto(userId, items);
	    
	    OrderResponseDto result = orderService.createOrder(dto);

	    if (result != null) {
	        ra.addFlashAttribute("msg", "Order has been placed");
	        return "redirect:/food/menu";
	    } else {
	        ra.addFlashAttribute("error", "Order failed");
	        return "redirect:/order-page/order?foodId=" + foodId;
	    }
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id) {
//		OrderRequestDto order=orderService.getById(id);
//		return ResponseEntity.ok(order);
//	}
//	
	@GetMapping("/admin-dashboard")
	public ModelAndView getAll() {

	    List<OrderResponseDto> orderList = orderService.getAll();
	    
	    System.out.println(orderList.size());
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("orderList", orderList);
	    mav.setViewName("admin-dashboard"); // ✅ NO redirect

	    return mav;
	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteById(@PathVariable Long id) {
//		orderService.deleteById(id);
//		return new ResponseEntity<String>("Delected successfull",HttpStatus.OK);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<OrderRequestDto> updateUserById(@PathVariable Long id,@RequestBody OrderRequestDto or) {
//		OrderRequestDto or2=orderService.updateById(id, or);
//		return new ResponseEntity<OrderRequestDto>(or2,HttpStatus.OK);
//	}
}
