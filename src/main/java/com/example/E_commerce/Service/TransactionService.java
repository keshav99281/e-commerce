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

    public Transaction Addtransaction(int id){
        Transaction transaction = new Transaction();
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()){
            Order newOrder = order.get();
            transaction.setUserId(newOrder.getUserId());
            transaction.setOrderId(id);
            transaction.setPrice(newOrder.getOrderPrice());
            return transactionRepository.save(transaction);
        }else throw new IllegalArgumentException("Order not found!!");
    }

    public List<Transaction> GetUserTransaction(long id){
        return transactionRepository.findByUserId(id);
    }

    public List<Transaction> GetAll(){
        return transactionRepository.findAll();
    }

    public List<Transaction> GetItemTransaction(long id){
        return transactionRepository.findByOrderId(id);
    }

}
