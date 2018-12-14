package edu.whitehou.service.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import edu.whitehou.entity.Order;

import java.util.Collection;

/**
 * @author : white.hou
 * @description :
 * @date: 2018/12/4_9:53
 */
public interface OrderService {
    /**
     * 查询所有订单列表
     * @return
     */
    Collection<Order> findAllOrder();
    /**
     * 根据用户唯一身份Id查询该用户下所有订单
     * @param userId
     * @return
     */
    Collection<Order> findOrderByUserId(String userId);

    /**
     * 列表显示该产品下的所有订单信息
     * @param productId
     * @return
     */
    Collection<Order> findOrderByProductId(String productId);

    /**
     * 根据条件查询指定订单
     * @param userId
     * @param productId
     * @return
     */
    Collection<Order> findOrderByCondition(String userId,String productId);

    /**
     * 根据订单id查询订单信息
     * @param orderId
     * @return
     */
    Order findOrderByOrderId(Integer orderId);
}
