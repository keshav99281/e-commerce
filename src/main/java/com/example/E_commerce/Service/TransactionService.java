package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Order;
import com.example.E_commerce.Model.Transaction;
import com.example.E_commerce.Repository.OrderRepository;
import com.example.E_commerce.Repository.TransactionRepository;
import com.example.E_commerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    public Transaction Addtransaction(int orderId){
        Transaction transaction = new Transaction();
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()){
            Order newOrder = order.get();
            transaction.setUserId(newOrder.getUserId());
            transaction.setOrderId(orderId);
            transaction.setPrice(newOrder.getOrderPrice());
            return transactionRepository.save(transaction);
        }else throw new IllegalArgumentException("Order not found!!");
    }

    public List<Transaction> GetUserTransaction(long userId){
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> GetAllTransaction(){
        return transactionRepository.findAll();
    }

}
