package edu.whitehou.mapper;

import edu.whitehou.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author : white.hou
 * @description : 订单的mapper接口
 * @date: 2018/12/3_21:15
 */
@Repository
public interface OrderMapper {
    /**
     * 列表显示所有订单
     */
    Collection<Order> findAllOrder();
    /**
     * 根据订单ID显示订单数据
     */
    Order findOrderByOrdeerId(Integer orderId);
    /**
     * 统计用户订单：用户名统计、用户姓名统计
     */
    Collection<Order> findOrderByUserId(String userId);
    /**
     * 统计产品订单
     */
    Collection<Order> findOrderByProductId(String productId);
    /**
     * 统计某用户对某产品的所有订单
     */
    Collection<Order> findOrderByCondition(String userId,String productId);

}
