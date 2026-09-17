package com.example.demo.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Food;
import com.example.demo.Service.FoodService;

import jakarta.validation.Valid;

@RestController
@Validated
public class FoodController {
	
	@Autowired
	FoodService foodservice;
	
	@GetMapping("/orders")
	public List<Food> getAllOrders()
	{
		return foodservice.getAllOrders();
	}
	
	@GetMapping("/getbyid/{id}")
	public Food getById(@PathVariable int id)
	{
		return foodservice.getById(id);
	}
	
	@PostMapping("/add")
	public String addorder(@Valid@RequestBody Food food) {
	    return foodservice.addOrder(food);
	}
	
	@PutMapping("/updateorder/{id}")
	public String updateFood(@PathVariable int id,@RequestBody Food Update)
	{
		return  foodservice.updateFood(id, Update);
	}
	
	@GetMapping("/count")
	public int getTotalOrder()
	{
		return foodservice.getTotalOrder();
	}

}
