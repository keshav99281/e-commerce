package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Model.Order;

import com.example.E_commerce.Repository.ItemRepository;
import com.example.E_commerce.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    public String AddOrder(int userId, int itemId, int quantity){
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()) {
            Order order = new Order();
            BigDecimal price = item.get().getPrice().multiply(BigDecimal.valueOf(quantity));
            order.setUser_id(userId);
            order.setItem_id(itemId);
            order.setQuantity(quantity);
            order.setOrder_price(price);
            orderRepository.save(order);
            return "Order has been successfully placed. Order ID: "+order.getOrder_id();
        }else return "Order can't be placed!!";
    }

    public List<Order> GetOrderUser(int id){
        return orderRepository.findByUserId(id);
    }

    public List<Order> GetOrderAdmin(){
        return orderRepository.findAll();
    }

}
