package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Model.Order;

import com.example.E_commerce.Repository.ItemRepository;
import com.example.E_commerce.Repository.OrderRepository;
import com.example.E_commerce.Repository.TransactionRepository;
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
    @Autowired
    private TransactionRepository transactionRepository;

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

    public List<Order> GetUserOrders(int userId){
        return orderRepository.findByUserId(userId);
    }

    public List<Order> GetAllOrders(){
        return orderRepository.findAll();
    }
    @Transactional
    public String DeleteOrder(int orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            Optional<Item> optionalItem = itemRepository.findById((int)order.getItemId());
            if(optionalItem.isPresent()){
                Item item = optionalItem.get();
                item.setQuantity(item.getQuantity()+order.getQuantity());
                orderRepository.deleteById(orderId);
                itemRepository.save(item);
                return "Order cancelled"+orderId;
            }else{
                return "Item associated with order " + orderId + " not found!";
            }
        }else {
            return "Order with "+ orderId +"not found!!";
        }
    }

}
