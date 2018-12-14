package edu.whitehou.service.service.impl;

import edu.whitehou.entity.Order;
import edu.whitehou.mapper.OrderMapper;
import edu.whitehou.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author : white.hou
 * @description : 订单服务的实现类
 * @date: 2018/12/4_9:57
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Collection<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @Override
    public Collection<Order> findOrderByUserId(String userId) {
        return orderMapper.findOrderByUserId(userId);
    }

    @Override
    public Collection<Order> findOrderByProductId(String productId) {
        return orderMapper.findOrderByProductId(productId);
    }

    @Override
    public Collection<Order> findOrderByCondition(String userId, String productId) {
        return orderMapper.findOrderByCondition(userId,productId);
    }

    @Override
    public Order findOrderByOrderId(Integer orderId) {
        return orderMapper.findOrderByOrdeerId(orderId);
    }
}
