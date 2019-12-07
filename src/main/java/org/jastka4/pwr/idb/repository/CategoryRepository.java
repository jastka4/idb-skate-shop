package org.jastka4.pwr.idb.repository;

import org.jastka4.pwr.idb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(final int id);
}
