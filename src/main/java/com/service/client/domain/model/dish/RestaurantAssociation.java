package com.service.client.domain.model.dish;


public class RestaurantAssociation {
    private Long restaurantId;

    

    public RestaurantAssociation() {}

    public RestaurantAssociation(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }

    @Override
    public String toString() {
        return "RestaurantAssociation [restaurantId=" + restaurantId + "]";
    }

    
}
