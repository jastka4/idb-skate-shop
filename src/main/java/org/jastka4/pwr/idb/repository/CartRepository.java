package org.jastka4.pwr.idb.repository;

import org.jastka4.pwr.idb.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findById(final int id);
}
