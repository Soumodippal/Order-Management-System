package com.example.model;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Spring MVC doesn't support AutoTime stamp that's why we have to manually put date and time
    private LocalDateTime createdAt;
    
    @JsonManagedReference
    @OneToMany(
    	    mappedBy = "order",
    	    cascade = CascadeType.ALL,
    	    fetch = FetchType.EAGER
    	)
    	private List<OrderItem> orderitems;

//    @OneToMany(
//    	    mappedBy = "order",
//    	    cascade = CascadeType.ALL,
//    	    fetch = FetchType.LAZY,
//    	    orphanRemoval = true
//    	)
//    	private List<OrderItem> orderItems; -->Recommended by Chatgpt for jsp use 
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, User user, OrderStatus status, BigDecimal totalPrice, LocalDateTime createdAt,
			List<OrderItem> orderitems) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
		this.totalPrice = totalPrice;
		this.createdAt = createdAt;
		this.orderitems = orderitems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	



    
}