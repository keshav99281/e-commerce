package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Order;
import com.example.E_commerce.Model.Transaction;
import com.example.E_commerce.Repository.OrderRepository;
import com.example.E_commerce.Repository.TransactionRepository;
import com.example.E_commerce.Repository.UserRepository;
import com.example.E_commerce.ServiceInterface.TransactionServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements TransactionServiceInterf {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> addTransaction(int orderId){
        try{
            Transaction transaction = new Transaction();
            Optional<Order> order = orderRepository.findById(orderId);
            if(order.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found!!");
            }
                Order newOrder = order.get();
                transaction.setUserId(newOrder.getUserId());
                transaction.setOrderId(orderId);
                transaction.setPrice(newOrder.getOrderPrice());
                transactionRepository.save(transaction);
                return ResponseEntity.ok().body("Order Completed!!");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occured!!");
        }
    }

    public ResponseEntity<?> GetUserTransaction(long userId){

        return ResponseEntity.ok(transactionRepository.findByUserId(userId));
    }

    public ResponseEntity<?> GetAllTransaction(){
        return ResponseEntity.status(HttpStatus.OK).body(transactionRepository.findAll());
    }

}
