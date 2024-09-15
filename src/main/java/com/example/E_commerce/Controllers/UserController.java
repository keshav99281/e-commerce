package com.example.E_commerce.Controllers;

import com.example.E_commerce.Model.Order;
import com.example.E_commerce.Model.Transaction;
import com.example.E_commerce.Model.User;
import com.example.E_commerce.Service.OrderService;
import com.example.E_commerce.Service.TransactionService;
import com.example.E_commerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/register")
    public String Register(@RequestBody User user){
        userService.addUser(user);
        return user.getName()+" Has been added!!";
    }

    @PutMapping("/update/{id}")//userId
    public String UpdateUserDetails(@PathVariable int id,@RequestBody User user){
        return userService.Update(id, user.getName(), user.getUsername(), user.getPassword());
    }

    @PostMapping("/order/add/{id}")//userId
    public String AddOrder(@PathVariable long id ,@RequestBody Order order){
        return orderService.AddOrder(id,order.getItemId(),order.getQuantity());
    }

    @GetMapping("/order/getOrders/{id}")//userId
    public List<Order> GetAllOrders(@PathVariable int id){
        return orderService.GetOrderUser(id);
    }

    @PostMapping("/order/confirm/{id}")//orderId
    public Transaction ConfirmOrder(@PathVariable int id){
        return transactionService.Addtransaction(id);
    }

    @GetMapping("transaction/getAll/{id}")//userId
    public List<Transaction> GetAllUserTransaction(@PathVariable int id){
        return transactionService.GetUserTransaction(id);
    }

}
