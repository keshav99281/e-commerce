package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Model.Order;

import com.example.E_commerce.Repository.ItemRepository;
import com.example.E_commerce.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

    public String AddOrder(long userId, long itemId, long quantity){
        Optional<Item> oldItem = itemRepository.findById((int) itemId);
        if(oldItem.isPresent() && quantity< oldItem.get().getQuantity()) {
            Order order = new Order();
            BigDecimal price = oldItem.get().getPrice().multiply(BigDecimal.valueOf(quantity));
            order.setUserId(userId);
            order.setItemId(itemId);
            order.setQuantity(quantity);
            order.setOrderPrice(price);
            orderRepository.save(order);
            oldItem.get().setQuantity(oldItem.get().getQuantity()-quantity);
            itemRepository.save(oldItem.get());
            return "Order has been successfully placed. Order ID: "+order.getOrderId();
        }else return "Order can't be placed!!Either the stock or oldItem is not available";
    }

    public List<Order> GetOrderUser(long id){
        return orderRepository.findByUserId(id);
    }

    public List<Order> GetOrderAdmin(){
        return orderRepository.findAll();
    }
    @Transactional
    public String DeleteOrder(int id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order order = optionalOrder.get();
        Optional<Item> item = itemRepository.findById((int)orderRepository.findById((int)id).get().getItemId());
        orderRepository.deleteById((int) id);
        Item item1 = item.get();
        item1.setQuantity(item1.getQuantity()+order.getQuantity());
        itemRepository.save(item1);
        return "Order Cancelled:"+id;
    }

}
