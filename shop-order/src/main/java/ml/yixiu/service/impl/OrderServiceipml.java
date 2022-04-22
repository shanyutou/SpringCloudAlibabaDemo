package ml.yixiu.service.impl;

import ml.yixiu.dao.OrderDao;
import ml.yixiu.domain.Order;
import ml.yixiu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceipml implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public void create(Order order) {
        orderDao.save(order);
    }
}
