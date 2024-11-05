package com.example.E_commerce.ServiceInterface;

import com.example.E_commerce.Model.Order;
import com.example.E_commerce.Repository.OrderRepository;

import java.util.List;

public interface OrderServiceInterf {
    String AddOrder(long userId, long itemId, long quantity);
    List<Order> GetUserOrders(int userId);
    List<Order> GetAllOrders();
    String DeleteOrder(int orderId);
}
