package com.example.demo.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
	
    private int id;
    @NotBlank(message="customer name is required")
	private String  name;
    @NotBlank(message="food item cannot be empty")
	private String  foodname;
    @Min(value=1,message="Quantity mus be at least 1")
	private int quantity;
    @NotNull(message="Price is mandotory")
	private double price;
	

}
