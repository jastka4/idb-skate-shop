package org.jastka4.pwr.idb.service.impl;

import org.jastka4.pwr.idb.model.Order;
import org.jastka4.pwr.idb.repository.OrderRepository;
import org.jastka4.pwr.idb.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Resource
    OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
