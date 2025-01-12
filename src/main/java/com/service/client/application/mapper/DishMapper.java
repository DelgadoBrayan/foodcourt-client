package com.service.client.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.service.client.application.dto.dish.DishDto;
import com.service.client.domain.model.dish.Dish;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(source = "dishInfo.name", target = "name")
    @Mapping(source = "dishInfo.price", target = "price")
    @Mapping(source = "dishInfo.description", target = "description")
    @Mapping(source = "dishInfo.urlImage", target = "urlImage")
    @Mapping(source = "dishInfo.category", target = "category")
    @Mapping(source = "restaurantAssociation.restaurantId", target = "restaurantId")
    @Mapping(source = "active", target = "active")
    DishDto toDishDto(Dish dish);

    @Mapping(source = "name", target = "dishInfo.name")
    @Mapping(source = "price", target = "dishInfo.price")
    @Mapping(source = "description", target = "dishInfo.description")
    @Mapping(source = "urlImage", target = "dishInfo.urlImage")
    @Mapping(source = "category", target = "dishInfo.category")
    @Mapping(source = "restaurantId", target = "restaurantAssociation.restaurantId")
    @Mapping(source = "active", target = "active")
    Dish toDish(DishDto dishDto);
    List<DishDto> toDishDtoList(List<Dish> dishes);
    List<Dish> toDishList(List<DishDto> dishDtos);
}