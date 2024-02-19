package org.refrigeratorApp.services;

import org.refrigeratorApp.dtos.FoodItemDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    @Transactional
    void addFoodItem(FoodItemDto foodItemDto, Long userId);

    @Transactional
    void deleteFoodItemById(Long foodItemId);

    @Transactional
    void updateFoodItemById(FoodItemDto foodItemDto);

    List<FoodItemDto> getAllFoodItemsByUserId(Long userId);

    Optional<FoodItemDto> getFoodItemById(Long foodItemId);
}
