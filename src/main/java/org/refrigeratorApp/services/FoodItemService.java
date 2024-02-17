package org.refrigeratorApp.services;

import org.refrigeratorApp.dtos.FoodItemDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    @Transactional
    static void addFoodItem(FoodItemDto foodItemDto, Long userId);

    @Transactional
    void deleteFoodItemById(Long foodItemId);

    @Transactional
    static void updateFoodItemById(FoodItemDto foodItemDto);

    static List<FoodItemDto> getAllFoodItemsByUserId(Long userId);

    static Optional<FoodItemDto> getFoodItemById(Long foodItemId);
}
