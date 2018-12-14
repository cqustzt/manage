package edu.whitehou.controller;

import edu.whitehou.entity.Order;
import edu.whitehou.entity.Root;
import edu.whitehou.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author : white.hou
 * @description : 订单的controller
 * @date: 2018/12/4_16:42
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表显示所有的订单
     * @return
     */
    @GetMapping("/orders")
    public String orderList(Model model){
        Collection<Order> allOrder = orderService.findAllOrder();
        model.addAttribute("orders",allOrder);
        System.out.println(model);
        return "order/list";
    }
/*
    *//**
     * 调转到具体的根据用户id或者产品id统计的页面
     * @return
     *//*
    @GetMapping("/order")
    public String toList(){
        return null;
    }*/
/*    @GetMapping("/order/{orderId}")
    public Collection<Order> findOrderByUserId(@PathVariable("orderId")Integer orderId){
        Order orderByOrderId = orderService.findOrderByOrderId(orderId);
        String userId = orderByOrderId.getUserId();
        Collection<Order> orderByUserId = orderService.findOrderByUserId(userId);
        return orderByUserId;

    }*/
  /*  @GetMapping("/order/{productId}")
    public Collection<Order> findOrderByProductId(@PathVariable("productId") String productId){
     *//*   Order orderByOrderId = orderService.findOrderByOrderId(custmorId);
        String productId = orderByOrderId.getProductId();*//*
        Collection<Order> orderByUserId = orderService.findOrderByProductId(productId);
        return orderByUserId;
    }*/

    /**
     * 根据给定条件查询对应订单信息
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping(value = "/order",method =GET)
    public Collection<Order> findOrderByCondition(@RequestParam(value = "userId")String userId,@RequestParam(value = "productId") String productId){
        if (userId!=null && productId==null){
            Collection<Order> orderByUserId = orderService.findOrderByUserId(userId);
            return orderByUserId;
        }else if (productId!=null &&userId ==null){
            Collection<Order> orderByProductId = orderService.findOrderByProductId(productId);
            return orderByProductId;
        }else{
            Collection<Order> orderByCondition = orderService.findOrderByCondition(userId, productId);
            return orderByCondition;
        }
    }
}
