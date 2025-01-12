package com.service.client.domain.model.order;

import java.util.List;


public class Order {
    private String id;
    private Long idRestaurant;
    private Long idClient;
    private Number quantity;
    private List<Long> dishes;
    private OrderStatus status;

    
    public Order(){}
    public Order(String id, Long idRestaurant, Long idClient,Number quantity ,List<Long> dishes, OrderStatus status) {
        this.id = id;
        this.idRestaurant = idRestaurant;
        this.idClient = idClient;
        this.quantity = quantity;
        this.dishes = dishes;
        this.status = status;
    }


    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    
    public Long getIdRestaurant() {return idRestaurant;}
    public void setIdRestaurant(Long idRestaurant) {this.idRestaurant = idRestaurant;}

    public Long getIdClient() {return idClient;}
    public void setIdClient(Long idClient) {this.idClient = idClient;}

    public Number getQuantity() {return quantity;}
    public void setQuantity(Number quantity) {this.quantity = quantity;}

    public List<Long> getDishes() {return dishes;}
    public void setDishes(List<Long> dishes) {this.dishes = dishes;}

    public OrderStatus getStatus() {return status;}
    public void setStatus(OrderStatus estado) {this.status = estado;}
    @Override
    public String toString() {
        return "Order [id=" + id + ", idRestaurant=" + idRestaurant + ", idClient=" + idClient + ", quantity="
                + quantity + ", dishes=" + dishes + ", status=" + status + "]";
    }
    
    
}
