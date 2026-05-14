package com.example.model;

public enum OrderStatus {
	PENDING,
	PREPARING,
	DELIVERED;
}

//User → Order = ManyToOne
//Order → OrderItem = OneToMany
//OrderItem → FoodItem = ManyToOne