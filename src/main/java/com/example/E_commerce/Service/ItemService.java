package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> GetAll(){
        return itemRepository.findAll();
    }

    public void DeleteById(int id){
        itemRepository.deleteById(id);
    }

    public String Update(int id, String newName, BigDecimal newPrice, int newQuantity){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            Item newItem = item.get();
            newItem.setItem_name(newName);
            newItem.setQuantity(newQuantity);
            newItem.setPrice(newPrice);
            itemRepository.save(newItem);
            return "Student details updated with id:"+newItem.getItem_id();
        }else return "No student found with id:"+id;
    }

}
