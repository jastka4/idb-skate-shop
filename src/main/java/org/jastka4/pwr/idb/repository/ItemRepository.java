package org.jastka4.pwr.idb.repository;

import org.jastka4.pwr.idb.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(final String name);
    Item findById(final int id);
    List<Item> findAll();
    Item save(final Item item);
}
