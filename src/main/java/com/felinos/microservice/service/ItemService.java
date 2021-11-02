package com.felinos.microservice.service;

import com.felinos.microservice.entities.Item;
import com.felinos.microservice.entities.User;
import com.felinos.microservice.repository.ItemRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ItemService {

    private ItemRepository itemRepository;

    public Item findItemById(long uid) {
        Item itemId = null;
        itemId = this.itemRepository.findById(uid) ;
        return itemId;
    }

    public Item addItem(Item i) {
        Item added =itemRepository.save(i);
        return added;
    }

    public void updateOrder(Item item, long itemId) {
        item.setItem_id(itemId);
        itemRepository.save(item);
    }

    public void deleteItem(long iid) {
        itemRepository.deleteById( iid);
    }


}
