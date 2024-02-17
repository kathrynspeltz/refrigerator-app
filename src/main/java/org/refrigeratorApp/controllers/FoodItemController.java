package org.refrigeratorApp.controllers;

import org.refrigeratorApp.dtos.FoodItemDto;
import org.refrigeratorApp.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("foodItems")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/user/{userId}")
    public List<FoodItemDto> getAllFoodItemsByUserId(@PathVariable Long userId){
        return FoodItemService.getAllFoodItemsByUserId(userId);
    }

    @GetMapping("/{FoodItemId}")
    public Optional<FoodItemDto> getFoodItemById(@PathVariable Long FoodItemId){
        return FoodItemService.getFoodItemById(FoodItemId);
    }

    @PostMapping("/user/{userId}")
    public void addFoodItem(@RequestBody FoodItemDto FoodItemDto, @PathVariable Long userId){
        FoodItemService.addFoodItem(FoodItemDto, userId);
    }

    @DeleteMapping("/{FoodItemId}")
    public void deleteFoodItemById(@PathVariable Long FoodItemId){
        FoodItemService.deleteFoodItemById(FoodItemId);
    }

    @PutMapping
    public void updateFoodItem(@RequestBody FoodItemDto FoodItemDto){
        FoodItemService.updateFoodItemById(FoodItemDto);
    }
}
