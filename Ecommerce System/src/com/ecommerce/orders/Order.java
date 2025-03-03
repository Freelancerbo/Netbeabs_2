package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.List;

public class Order {
    private int orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;

    public Order(int orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.orderTotal = calculateOrderTotal();
    }

    private double calculateOrderTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void updateOrderStatus() {
        // Implement order status update logic
    }

    public String generateOrderSummary() {
        return "Order{" +
                "orderID=" + orderID +
                ", customer=" + customer +
                ", products=" + products +
                ", orderTotal=" + orderTotal +
                '}';
    }
}
