package edu.whitehou.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author : white.hou
 * @description : 订单实体类
 * @date: 2018/12/3_21:19
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 6457152037251482654L;
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     *购买的产品ID
     */
    private String productId;
    /**
     * 购买者ID
     */
    private  String userId;
    /**
     * 实际付款
     */
    private BigDecimal payment;
    /**
     * 付款状态,1 未付款 2 已付款
     */
    private  Integer status;
    /**
     * 支付类型：1 支付宝 2 微信支付 3 校园卡支付
     */
    private Integer paymentType;
    /**
     * 订单创建时间
     */
    private Timestamp creatTime;
    /**
     * 支付完成时间
     */
    private Timestamp  paymentTime;
    /**
     * 交易完成时间
     */
    private Timestamp endTime;
    /**
     * 订单关闭时间,sql包装器类中 date取年日月，time取时分秒，timestam都取
     */
    private Timestamp closeTime;

}
