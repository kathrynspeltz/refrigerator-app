package org.refrigeratorApp.repositories;

import org.refrigeratorApp.entities.FoodItem;
import org.refrigeratorApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findAllByUserEquals(User user);

}
