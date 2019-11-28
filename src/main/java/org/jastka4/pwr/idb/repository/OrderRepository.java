package org.jastka4.pwr.idb.repository;

import org.jastka4.pwr.idb.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findById(final int id);
}
