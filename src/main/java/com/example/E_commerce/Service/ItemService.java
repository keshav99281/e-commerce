package com.example.E_commerce.Service;

import com.example.E_commerce.Model.Item;
import com.example.E_commerce.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item){//checked
        return itemRepository.save(item);
    }

    public List<Item> GetAll(){//checked
        return itemRepository.findAll();
    }

    public String DeleteById(int id){//checked
        Item item = new Item();
        String name = item.getItemName();
        itemRepository.deleteById(id);
        return name+" has been deleted...";
    }

    public String Update(int id, String newName, BigDecimal newPrice, long newQuantity){//partial success
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            Item newItem = item.get();
            updateField(newItem,newName,"name");
            updateField(newItem, String.valueOf(newPrice),"price");
            updateField(newItem, String.valueOf(newQuantity),"quantity");
            itemRepository.save(newItem);
            return "Item details updated with id:"+newItem.getItemName();
        }else return "No Item found with id:"+id;
    }

    private void updateField(Item item, String newValue, String fieldName){
        if (newValue!=null && !newValue.isBlank()){
            switch (fieldName){
                case "itemName":
                    item.setItemName(newValue);
                    break;
                case "price":
                    item.setPrice(BigDecimal.valueOf(Long.parseLong(newValue)));
                    break;
                case "quantity":
                    item.setQuantity(Long.parseLong(newValue));
                    break;
                default:
                    throw new IllegalArgumentException("No Such Column present in table or " +
                            "check the column name and try again!!");
            }
        }
    }

}
