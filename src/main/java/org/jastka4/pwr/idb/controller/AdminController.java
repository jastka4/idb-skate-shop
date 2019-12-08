package org.jastka4.pwr.idb.controller;

import org.jastka4.pwr.idb.dto.CategoryDTO;
import org.jastka4.pwr.idb.model.Item;
import org.jastka4.pwr.idb.service.ICategoryService;
import org.jastka4.pwr.idb.service.IOrderService;
import org.jastka4.pwr.idb.service.impl.ItemService;
import org.jastka4.pwr.idb.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final String ADMIN_PAGE_PREFIX = "/admin";
    private static final String ADMIN_PRODUCTS_PAGE = ADMIN_PAGE_PREFIX + "/products";
    private static final String ADMIN_HOME_PAGE = ADMIN_PAGE_PREFIX + "/home";
    private static final String ADMIN_USERS_PAGE = ADMIN_PAGE_PREFIX + "/users";
    private static final String ADMIN_CATEGORIES_PAGE = ADMIN_PAGE_PREFIX + "/categories";
    private static final String ADMIN_ORDERS_PAGE = ADMIN_PAGE_PREFIX + "/orders";

    @Resource
    private UserService userService;

    @Resource
    private ItemService itemService;

    @Resource
    private IOrderService orderService;

    @Resource
    private ICategoryService categoryService;

    @GetMapping(value = "/home")
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersCount", userService.findAll().size());
        modelAndView.addObject("itemsCount", itemService.findAll().size());
        modelAndView.addObject("categoriesCount", categoryService.getAll().size());
        modelAndView.addObject("ordersCount", orderService.getAll().size());
        modelAndView.setViewName(ADMIN_HOME_PAGE);
        return modelAndView;
    }

    @GetMapping(value = "/customers")
    public ModelAndView customersList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName(ADMIN_USERS_PAGE);
        return modelAndView;
    }

    @GetMapping(value = "/products")
    public ModelAndView productList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", itemService.findAll());
        modelAndView.setViewName(ADMIN_PRODUCTS_PAGE);
        return modelAndView;
    }

    @GetMapping(value = "/products/add")
    public ModelAndView getAddProductPage() {
        final Item item = new Item();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("create", true);
        modelAndView.addObject("item", item);
        modelAndView.setViewName(ADMIN_PRODUCTS_PAGE);
        return modelAndView;
    }

    @PostMapping(value = "/products/add")
    public @ResponseBody
    ModelAndView addProduct(final Item item, final BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (itemService.findItemByName(item.getName()) != null) {
            bindingResult.rejectValue("name", "error.item", "Product already exists!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(ADMIN_PRODUCTS_PAGE);
        } else {
            itemService.saveItem(item);
            modelAndView.addObject("create", true);
            modelAndView.addObject("successMessage", "Product has been added successfully!");
            modelAndView.addObject("item", new Item());
            modelAndView.setViewName(ADMIN_PRODUCTS_PAGE);
        }
        return modelAndView;
    }

    @PostMapping(value = "/products")
    public String removeProduct(@RequestParam(value = "id") final long categoryId) {
        itemService.remove(categoryId);

        return "redirect:" + ADMIN_PRODUCTS_PAGE;
    }

    @GetMapping(value = "/categories")
    public ModelAndView categoriesList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories", categoryService.getAll());
        modelAndView.setViewName(ADMIN_CATEGORIES_PAGE);
        return modelAndView;
    }

    @GetMapping(value = "/categories/add")
    public ModelAndView getAddCategoryPage() {
        final CategoryDTO category = new CategoryDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("create", true);
        modelAndView.addObject("category", category);
        modelAndView.setViewName(ADMIN_CATEGORIES_PAGE);
        return modelAndView;
    }

    @PostMapping(value = "/categories/add")
    public @ResponseBody
    ModelAndView addCategory(final CategoryDTO category, final BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (categoryService.getCategory(category.getId()) != null) {
            bindingResult.rejectValue("name", "error.item", "Category already exists!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(ADMIN_CATEGORIES_PAGE);
        } else {
            categoryService.save(category);
            modelAndView.addObject("create", true);
            modelAndView.addObject("successMessage", "Category has been added successfully!");
            modelAndView.addObject("category", new CategoryDTO());
            modelAndView.setViewName(ADMIN_CATEGORIES_PAGE);
        }
        return modelAndView;
    }

    @PostMapping(value = "/categories")
    public String removeCategory(@RequestParam(value = "id") final long categoryId) {
        categoryService.remove(categoryId);

        return "redirect:" + ADMIN_CATEGORIES_PAGE;
    }

    @GetMapping(value = "/orders")
    public ModelAndView ordersList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders", orderService.getAll());
        modelAndView.setViewName(ADMIN_ORDERS_PAGE);
        return modelAndView;
    }
}
