package com.example.E_commerce.Controllers;

import com.example.E_commerce.Model.Order;
import com.example.E_commerce.Model.Transaction;
import com.example.E_commerce.Model.User;
import com.example.E_commerce.Service.OrderService;
import com.example.E_commerce.Service.TransactionService;
import com.example.E_commerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/register")//working
    public ResponseEntity<?> Register(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update/{userId}")//working
    public String UpdateUserDetails(@PathVariable int userId, @RequestBody User user){
        return userService.Update(userId, user.getName(), user.getUserName(), user.getPassword());
    }

    @PostMapping("/order/add/{userId}")
    public String AddOrder(@PathVariable long id ,@RequestBody Order order){
        return orderService.AddOrder(id,order.getItemId(),order.getQuantity());
    }

    @GetMapping("/order/getOrders/{userId}")
    public List<Order> GetAllOrders(@PathVariable int userId){
        return orderService.GetUserOrders(userId);
    }

    @PostMapping("/order/confirm/{orderId}")
    public Transaction ConfirmOrder(@PathVariable int orderId){
        return transactionService.Addtransaction(orderId);
    }

    @GetMapping("transaction/getAll/{userId}")
    public List<Transaction> GetAllUserTransaction(@PathVariable int userId){
        return transactionService.GetUserTransaction(userId);
    }

}
