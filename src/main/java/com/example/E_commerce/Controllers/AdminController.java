package com.example.E_commerce.Controllers;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Model.Order;
import com.example.E_commerce.Model.Transaction;
import com.example.E_commerce.Model.User;
import com.example.E_commerce.Service.ItemService;
import com.example.E_commerce.Service.OrderService;
import com.example.E_commerce.Service.TransactionService;
import com.example.E_commerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/getAll")//working
    public List<User> GetAllUsers(){
        return userService.GetAll();
    }

    @DeleteMapping("/user/delete/{id}")//working
    public String DeleteUser(@PathVariable int id){
        return userService.Delete(id);
    }

    @PostMapping("/item/add")
    public Item AddItem(@RequestBody Item item){
        return itemService.addItem(item);
    }

    @GetMapping("/item/getAll")//working
    public List<Item> GetAllItem(){
        return itemService.GetAll();
    }

    @PutMapping("/item/update/{itemId}")//working
    public String updateItem(@PathVariable int itemId,@RequestParam int quantity){
        return itemService.updateItemQuantity(itemId,quantity);
    }

    @DeleteMapping("/item/delete/{itemId}")//
    public String DeleteItem(@PathVariable int itemId){
        return itemService.DeleteById(itemId);
    }

    @GetMapping("/order/getOrders")
    public List<Order> GetAllOrders(){
        return orderService.GetAllOrders();
    }

    @GetMapping("/order/getOrders/{userId}")//
    public List<Order> GetAllOrders(@PathVariable int userId){
        return orderService.GetUserOrders(userId);
    }

    @DeleteMapping("/order/deleteOrder/{orderId}")//working
    public String deleteOrder(@PathVariable int orderId){
        return orderService.DeleteOrder(orderId);
    }

    @GetMapping("transaction/getAll")
    public List<Transaction> GetAllTransaction(){
        return transactionService.GetAllTransaction();
    }

    @GetMapping("transaction/user/getAll/{userId}")//
    public List<Transaction> GetAllUserTransaction(@PathVariable int userId){
        return transactionService.GetUserTransaction(userId);
    }



}
