package com.service.client.domain.model.dish;


public class Dish {
    private Long id;
    private DishInfo dishInfo;
    private RestaurantAssociation restaurantAssociation;
    private Boolean active;

    
    public Dish() {}

    public Dish(Long id, DishInfo dishInfo, RestaurantAssociation restaurantAssociation, Boolean active) {
        this.id = id;
        this.dishInfo = dishInfo;
        this.restaurantAssociation = restaurantAssociation;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public DishInfo getDishInfo() { return dishInfo; }
    public void setDishInfo(DishInfo dishInfo) { this.dishInfo = dishInfo; }

    public RestaurantAssociation getRestaurantAssociation() { return restaurantAssociation; }
    public void setRestaurantAssociation(RestaurantAssociation restaurantAssociation) { this.restaurantAssociation = restaurantAssociation; }

    public boolean isActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public void updatePrice(Double price) { 
        this.dishInfo.setPrice(price); 
    } 
    public void updateDescription(String description) { 
        this.dishInfo.setDescription(description); 
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", dishInfo=" + dishInfo + ", restaurantAssociation=" + restaurantAssociation
                + ", active=" + active + "]";
    }
    
}
