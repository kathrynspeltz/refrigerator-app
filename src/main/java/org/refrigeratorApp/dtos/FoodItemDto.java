package org.refrigeratorApp.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.refrigeratorApp.entities.FoodItem;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto implements Serializable {
        private Long id;
        private String itemName;
        private LocalDate dateAdded;
        private LocalDate expirationDate;

        public FoodItemDto(FoodItem FoodItem){
                if (FoodItem.getId() != null){
                        this.id = FoodItem.getId();
                }
                if (FoodItem.getItemName() != null){
                        this.itemName = FoodItem.getItemName();
                }
                if (FoodItem.getDateAdded() != null){
                        this.dateAdded = FoodItem.getDateAdded();
                }
                if (FoodItem.getExpirationDate() != null){
                        this.expirationDate = FoodItem.getExpirationDate();
                }
        }
}
