package org.refrigeratorApp.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.refrigeratorApp.dtos.FoodItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "FoodItems")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String itemName;

    @Column(columnDefinition = "date")
    private LocalDate dateAdded;

    @Column(columnDefinition = "date")
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value = "user_FoodItem")
    private User user;


    public FoodItem(FoodItemDto FoodItemDto) {
        if (FoodItemDto.getItemName() != null){
            this.itemName = FoodItemDto.getItemName();
        }
        if (FoodItemDto.getDateAdded() != null){
            this.dateAdded = FoodItemDto.getDateAdded();
        }
        if (FoodItemDto.getExpirationDate() != null){
            this.expirationDate = FoodItemDto.getExpirationDate();
        }
    }
}

