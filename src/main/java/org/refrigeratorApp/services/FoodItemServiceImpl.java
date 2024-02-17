package org.refrigeratorApp.services;

import org.refrigeratorApp.dtos.FoodItemDto;
import org.refrigeratorApp.entities.FoodItem;
import org.refrigeratorApp.entities.User;
import org.refrigeratorApp.repositories.FoodItemRepository;
import org.refrigeratorApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository FoodItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addFoodItem(FoodItemDto FoodItemDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        FoodItem FoodItem = new FoodItem(FoodItemDto);
        userOptional.ifPresent(FoodItem::setUser);
        FoodItemRepository.saveAndFlush(FoodItem);
    }

    @Override
    @Transactional
    public void deleteFoodItemById(Long FoodItemId) {
        Optional <FoodItem> FoodItemOptional = FoodItemRepository.findById(FoodItemId);
        FoodItemOptional.ifPresent(FoodItem -> FoodItemRepository.delete(FoodItem));
    }

    @Override
    @Transactional
    public void updateFoodItemById(FoodItemDto FoodItemDto) {
        Optional<FoodItem> FoodItemOptional = FoodItemRepository.findById(FoodItemDto.getId());
        FoodItemOptional.ifPresent( FoodItem -> {
            FoodItem.setItemName(FoodItemDto.getItemName());
            FoodItem.setDateAdded(FoodItemDto.getDateAdded());
            FoodItem.setExpirationDate(FoodItemDto.getExpirationDate());
            FoodItemRepository.saveAndFlush(FoodItem);
        });
    }

    @Override
    public List<FoodItemDto> getAllFoodItemsByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<FoodItem> FoodItemList = FoodItemRepository.findAllByUserEquals(userOptional.get());
            return FoodItemList.stream().map(FoodItem -> new FoodItemDto(FoodItem)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<FoodItemDto> getFoodItemById(Long FoodItemId) {
        Optional<FoodItem> FoodItemOptional = FoodItemRepository.findById(FoodItemId);
        if (FoodItemOptional.isPresent()){
            return Optional.of(new FoodItemDto(FoodItemOptional.get()));
        }
        return Optional.empty();

    }

}
