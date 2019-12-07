package org.jastka4.pwr.idb.service.impl;

import org.jastka4.pwr.idb.model.Category;
import org.jastka4.pwr.idb.repository.CategoryRepository;
import org.jastka4.pwr.idb.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService implements ICategoryService {
    private static final int LEVELS = 3;

    @Resource
    private CategoryRepository categoryRepository;

    public Category getCategory(final int id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getCategoriesHierarchy(final int firstCategoryId) {
        final List<Category> categories = new ArrayList<>();
        int searchedId = firstCategoryId;
        for (int i = 0; i < LEVELS; i++) {
            Category category = getCategory(searchedId);
            categories.add(category);
            if (Objects.nonNull(category.getParentCategory())) {
                searchedId = category.getParentCategory().getId();
            } else {
                break;
            }
        }

        Collections.reverse(categories);
        return categories;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
