package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Model.Order;

import com.example.E_commerce.Model.Transaction;
import com.example.E_commerce.Repository.ItemRepository;
import com.example.E_commerce.Repository.OrderRepository;
import com.example.E_commerce.Repository.TransactionRepository;
import com.example.E_commerce.ServiceInterface.OrderServiceInterf;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceInterf {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public String AddOrder(long userId, long itemId, long quantity){

        Optional<Item> oldItem = itemRepository.findById((int) itemId);

        //checks availability of item
        if(oldItem.isEmpty() || oldItem.get().getQuantity()==0){
            return "Item is not available!!";
        }

        //checks stock of item
        if(quantity > oldItem.get().getQuantity()){
            return "Insufficient stock!! Current item stock: "+ oldItem.get().getQuantity();
        }

        Order order = new Order();
        BigDecimal price = oldItem.get().getPrice().multiply(BigDecimal.valueOf(quantity));
        order.setUserId(userId);
        order.setItemId(itemId);
        order.setQuantity(quantity);
        order.setOrderPrice(price);
        orderRepository.save(order);

        //update item quantity
        Item item = oldItem.get();
        item.setQuantity(item.getQuantity()-quantity);
        itemRepository.save(item);
        return "Order has been successfully placed. Order ID: "+order.getOrderId();
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

        //checks availabilty of order
        if(optionalOrder.isEmpty()){
            return "No order match found!!";
        }

        Order order = optionalOrder.get();

        //checks whether order is finalized or not
        Optional<Transaction> optionalTransaction = transactionRepository.findByOrderId(orderId);
        if(optionalTransaction.isPresent()){
            return "Order is already completed so it can't be deleted!!";
        }

        //add quantity of item in order back to stock of item
        long quantity = order.getQuantity();
        Item item = itemRepository.findById((int)order.getItemId()).get();
        item.setQuantity(item.getQuantity()+quantity);
        itemRepository.save(item);

        orderRepository.deleteById(orderId);
        return "Order succesfully deleted!! Current stock of "+item.getItemName()+" is "+item.getQuantity();
    }

}
