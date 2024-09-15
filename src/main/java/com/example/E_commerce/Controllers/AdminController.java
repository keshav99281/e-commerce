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

    @GetMapping("/user/getAll")
    public List<User> GetAllUsers(){
        return userService.GetAll();
    }

    @DeleteMapping("/user/delete/{id}")//userId
    public String DeleteUser(@PathVariable int id){
        return userService.Delete(id);
    }

    @PostMapping("/item/add")
    public Item AddItem(@RequestBody Item item){
        return itemService.addItem(item);
    }

    @GetMapping("/item/getAll")
    public List<Item> GetAllItem(){
        return itemService.GetAll();
    }

    @PutMapping("/item/update/{id}")//itemId
    public String updateItem(@PathVariable int id,@RequestBody Item item){
        return itemService.Update(id,item.getItemName(),item.getPrice(),item.getQuantity());
    }

    @DeleteMapping("/item/delete/{id}")//itemId
    public String DeleteItem(@PathVariable int id){
        return itemService.DeleteById(id);
    }

    @GetMapping("/order/getOrders")
    public List<Order> GetAllOrders(){
        return orderService.GetOrderAdmin();
    }

    @GetMapping("/order/getOrders/{id}")//userId
    public List<Order> GetAllOrders(@PathVariable int id){
        return orderService.GetOrderUser(id);
    }

    @DeleteMapping("/order/deleteOrder/{id}")//orderId
    public String deleteOrder(@PathVariable int id){
        return orderService.DeleteOrder(id);
    }

    @GetMapping("transaction/getAll")
    public List<Transaction> GetAll(){
        return transactionService.GetAll();
    }

    @GetMapping("transaction/user/getAll/{id}")//userId
    public List<Transaction> GetAllUserTransaction(@PathVariable int id){
        return transactionService.GetUserTransaction(id);
    }

    @GetMapping("transaction/item/getAll/{id}")//itemId
    public List<Transaction> GetAllItemTransaction(@PathVariable int id){
        return transactionService.GetItemTransaction(id);
    }

}
