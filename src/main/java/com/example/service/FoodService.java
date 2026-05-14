package com.example.service;

import java.util.List;

import com.example.model.FoodItem;

public interface FoodService {
	
	public FoodItem createFood(FoodItem food);
	
	public FoodItem getById(Long id);
	
	public List<FoodItem> getAll();
	
	public void deleteById(Long id);
	
	public FoodItem updateById(Long id,FoodItem us);
	
}
