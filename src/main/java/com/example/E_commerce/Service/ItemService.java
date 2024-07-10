package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> GetAll(){
        return itemRepository.findAll();
    }


}
