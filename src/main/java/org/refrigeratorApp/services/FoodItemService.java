package org.refrigeratorApp.services;

import org.refrigeratorApp.dtos.FoodItemDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    @Transactional
    void addFoodItem(FoodItemDto FoodItemDto, Long userId);

    @Transactional
    void deleteFoodItemById(Long FoodItemId);

    @Transactional
    void updateFoodItemById(FoodItemDto FoodItemDto);

    List<FoodItemDto> getAllFoodItemsByUserId(Long userId);

    Optional<FoodItemDto> getFoodItemById(Long FoodItemId);
}
