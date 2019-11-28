package org.jastka4.pwr.idb.service;

import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class ItemService {
    private ItemRepository itemRepository;
    private List<Item> items;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item findItemByName(String name){ return itemRepository.findByName(name); }

    public Item findItemById(int id){ return itemRepository.findById(id); }

    public List<Item> findAll(){
        items = new ArrayList<>();
        for (int i = 1; findItemById(i) != null; i++){
            items.add(findItemById(i));
        }
        return items;
    }

    public Item saveItem(Item item){
        item.setAmount(1);

        itemRepository.save(item);
        return item;
    }
}
