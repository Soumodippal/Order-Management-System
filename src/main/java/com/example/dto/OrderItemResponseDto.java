package com.example.dto;

import java.math.BigDecimal;

public class OrderItemResponseDto {

    private Long foodId;
    private String foodName;
    private int quantity;
    private BigDecimal price;

    public OrderItemResponseDto() {}

    public OrderItemResponseDto(Long foodId, String foodName,
                                int quantity, BigDecimal price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}