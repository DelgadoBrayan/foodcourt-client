package com.service.client.domain.model.order;

import java.util.List;


public class Order {
    private String id;
    private Long idRestaurantLong;
    private Long idClient;
    private Number quantity;
    private List<Long> orders;
    private String status;

    

    public Order(String id, Long idRestaurantLong, Long idClient,Number quantity ,List<Long> orders, String status) {
        this.id = id;
        this.idRestaurantLong = idRestaurantLong;
        this.idClient = idClient;
        this.quantity = quantity;
        this.orders = orders;
        this.status = status;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    
    public Long getIdRestaurantLong() {return idRestaurantLong;}
    public void setIdRestaurantLong(Long idRestaurantLong) {this.idRestaurantLong = idRestaurantLong;}

    public Long getIdClient() {return idClient;}
    public void setIdClient(Long idClient) {this.idClient = idClient;}

    public Number getQuantity() {return quantity;}
    public void setQuantity(Number quantity) {this.quantity = quantity;}

    public List<Long> getOrders() {return orders;}
    public void setOrders(List<Long> orders) {this.orders = orders;}

    public String getStatus() {return status;}
    public void setStatus(String estado) {this.status = estado;}
    
}
