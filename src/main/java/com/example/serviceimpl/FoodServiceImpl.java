package com.example.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.FoodItem;
import com.example.repository.FoodItemRepository;
import com.example.service.FoodService;


@Service
public class FoodServiceImpl implements FoodService {
	
	private FoodItemRepository itemRepository;
	
	public FoodServiceImpl(FoodItemRepository itemRepository) {
		
		this.itemRepository=itemRepository;
	}

	
	public FoodItem createFood(FoodItem food) {
		FoodItem ur=itemRepository.save(food);
		return ur;
	}

	
	public FoodItem getById(Long id) {
		FoodItem ur=itemRepository.findById(id).orElseThrow(()-> new RuntimeException("User doesn't exists at this ID"));
		return ur;
	}

	
	public List<FoodItem> getAll() {
		List<FoodItem> foods=itemRepository.findAll();
		return foods;
	}
	
	
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
		
	}

	
	public FoodItem updateById(Long id,FoodItem fd) {
		FoodItem food=itemRepository.findById(id).orElse(null);
		if(food!=null) {
			food.setName(fd.getName());
			food.setDescription(fd.getDescription());
			food.setPrice(fd.getPrice());
			food.setAvailable(fd.isAvailable());
			
			return createFood(food);
		}
		return null;
	}


}
