package com.app.service;

import com.app.dao.OrderDAO;
import com.app.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public List<Order> findAll() {
        List<Order> res = orderDAO.findAll();
        return res;
    }
}
