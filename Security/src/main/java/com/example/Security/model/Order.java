package com.example.Security.model;

public class Order {
    private Long id;
    private String customerName;
    private Double total;

    public Order() {
    }

    public Order(Long id, String customerName, Double total) {
        this.id = id;
        this.customerName = customerName;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
