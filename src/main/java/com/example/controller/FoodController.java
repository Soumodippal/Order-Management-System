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
//import com.example.model.FoodItem;
//import com.example.service.FoodService;
//
//
//@RestController
//@RequestMapping("/food")
//public class FoodController {
//	
//private FoodService foodService;
//	
//	public FoodController(FoodService foodService) {
//		this.foodService=foodService;
//	}
//	
//	@PostMapping
//	public ResponseEntity<FoodItem> createFood(@RequestBody FoodItem food) {
//		FoodItem fd=foodService.createFood(food);
//		return new ResponseEntity<FoodItem>(fd,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<FoodItem> getById(@PathVariable Long id) {
//		FoodItem order=foodService.getById(id);
//		return ResponseEntity.ok(order);
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<FoodItem>> getAll(){
//		return  ResponseEntity.status(HttpStatus.OK).body(foodService.getAll());
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteById(@PathVariable Long id) {
//		foodService.deleteById(id);
//	}
//	
//	@PutMapping("/{id}")
//	public FoodItem updateFoodItem(@PathVariable Long id,@RequestBody FoodItem or) {
//		FoodItem or2=foodService.updateById(id, or);
//		return or2;
//	}
//}




package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.FoodItem;
import com.example.service.FoodService;


@Controller
@RequestMapping("/food")
public class FoodController {
	
private FoodService foodService;
	
	public FoodController(FoodService foodService) {
		this.foodService=foodService;
	}
	
//	@GetMapping
	
	@PostMapping
	public String createFood(@ModelAttribute FoodItem food) {
		FoodItem fd=foodService.createFood(food);
		
//		return "redirect:/user/admin-dashboard";
		return "redirect:/order-page/admin-dashboard";
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<FoodItem> getById(@PathVariable Long id) {
//		FoodItem order=foodService.getById(id);
//		return ResponseEntity.ok(order);
//	}
	
	@GetMapping("/menu")
	public ModelAndView getAll(){
		ModelAndView mav=new ModelAndView();
		List<FoodItem> foodList=foodService.getAll();
		mav.addObject("foodList",foodList);
		mav.setViewName("menu");
		return  mav;
	}
	
//	@DeleteMapping("/{id}")	
//	public void deleteById(@PathVariable Long id) {
//		foodService.deleteById(id);
//	}
	
//	@PutMapping("/{id}")
//	public FoodItem updateFoodItem(@PathVariable Long id,@RequestBody FoodItem or) {
//		FoodItem or2=foodService.updateById(id, or);
//		return or2;
//	}
}

