package com.example.E_commerce.ServiceInterface;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Repository.ItemRepository;

import java.util.List;

public interface ItemServiceInterf {
    Item addItem(Item item);
    List<Item> GetAll();
    String DeleteById(int itemId);
    String updateItemQuantity(int itemId, int newQuantity);
}
