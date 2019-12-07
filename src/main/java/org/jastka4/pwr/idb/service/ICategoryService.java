package org.jastka4.pwr.idb.service;

import org.jastka4.pwr.idb.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategory(final int id);

    List<Category> getCategoriesHierarchy(final int firstCategoryId);

    List<Category> getAll();
}
