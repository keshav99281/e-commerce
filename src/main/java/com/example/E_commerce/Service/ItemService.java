package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item){//checked
        return itemRepository.save(item);
    }

    public List<Item> GetAll(){//checked+working
        return itemRepository.findAll();
    }

    public String DeleteById(int itemId){//checked
        Item item = new Item();
        String name = item.getItemName();
        itemRepository.deleteById(itemId);
        return name+" has been deleted...";
    }

    public String updateItemQuantity(int itemId, int newQuantity){
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()){
            Item newItem = item.get();
            newItem.setQuantity(newItem.getQuantity()+newQuantity);
            itemRepository.save(newItem);
            return "Stock of item "+newItem.getItemName()+" increased by "+newQuantity+". Available stock is "+newItem.getQuantity();
        }return "Item not present in the market.";
    }

}
