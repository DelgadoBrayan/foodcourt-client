package com.service.client.application.dto.dish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String urlImage;
    private String category;
    private Long restaurantId;
    private Boolean active = true;

    public DishDto(Long id) {
        this.id = id;
    }
}
