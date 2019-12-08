package org.jastka4.pwr.idb.service.impl;

import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final static String ENGLISH = "en";
    private final static String POLISH = "pl";

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findItemByName(String name) {
        return itemRepository.findByName(name);
    }

    public Item findItemById(final long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item saveItem(Item item) {
        item.setAmount(1);

        itemRepository.save(item);
        return item;
    }

    public void remove(final long id) {
        itemRepository.deleteById(id);
    }

    public String getDescription(final Item item) {
        return switch (LocaleContextHolder.getLocale().getLanguage()) {
            case POLISH:
                yield item.getDescriptionPl();
            case ENGLISH:
            default:
                yield item.getDescriptionEn();
        };
    }

    public List<Item> getRecommendedItems(final Item item) {
        final List<Item> allItems = itemRepository.findAll();
        return allItems.stream()
                .filter(singleItem -> !singleItem.equals(item))
                .limit(3)
                .collect(Collectors.toList());
    }
}
