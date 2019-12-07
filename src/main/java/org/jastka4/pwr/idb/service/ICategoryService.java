package org.jastka4.pwr.idb.service;

import org.jastka4.pwr.idb.dto.CategoryDTO;
import org.jastka4.pwr.idb.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategory(final long id);

    List<Category> getCategoriesHierarchy(final int firstCategoryId);

    List<Category> getAll();

    Category save(final Category item);

    Category save(final CategoryDTO categoryDTO);

    void remove(final long id);
}
