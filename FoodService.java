package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.FoodNotFoundException;
import com.example.demo.Exception.InvalidQuantityException;
import com.example.demo.Model.*;

@Service
public class FoodService {
	
	List<Food> st=new ArrayList<>(
			Arrays.asList(new Food(1,"nithisha","burger",1,250),
					      new Food(2,"Kani","Briyani",2,350),
					      new Food(3,"oviya","Pizza",1,300),
					      new Food(4,"Kaviya","Dosa",1,100))
			
			 );
	
	// display orders
	public List<Food> getAllOrders()
	{
		return st;
	}
	
	//get the fooditems by id
	public Food getById(int id) {
	    for (Food f : st) {
	        if (f.getId() == id) {
	            return f;
	        }
	    }
	    throw new FoodNotFoundException("Food with id " + id + " not found");
	}
	
	// inssert
	public String addOrder(Food food) {
	    if (food.getQuantity() < 1) {
	        throw new InvalidQuantityException("Quantity must be at least 1");
	    }
	    st.add(food);
	    return "Food details are added successfully";
	}
	//for updating
	 public String updateFood(int id,Food update)
     {
    	 for(Food f:st)
    	 {
    		 if(f.getId()==id)
    		 {
    			 f.setId(update.getId());
    			 f.setName(update.getName());
    			 f.setFoodname(update.getFoodname());
    			 f.setQuantity(update.getQuantity());
    			 f.setPrice(update.getPrice());
    			 return"Food details  are updated successfully";
    		 }
    	 }
    	 return"Food details are not found";
    	 
     }
	 
	 public int getTotalOrder()
	 {
		 return st.size();
	 }
	
		
	
	

}
