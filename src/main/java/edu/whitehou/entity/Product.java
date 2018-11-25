package edu.whitehou.entity;

import java.math.BigDecimal;

/**
 * @author : white.hou
 * @description : 商品实体类
 * @date: 2018/11/25_14:36
 */
public class Product {
    /**
     * 数据库id
     */
    private Integer id;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品名
     */
    private String productName;
    /**
     * 商品身份属性，可以被什么身份的用户购买
     */
    private String identity;
    /**
     * 商品状态
     */
    private Integer state;
    /**
     * 商品价格
     */
    private BigDecimal price;

    public Product(Integer id, String productId, String productName, String identity, Integer state, BigDecimal price) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.identity = identity;
        this.state = state;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", identity='" + identity + '\'' +
                ", state=" + state +
                ", price=" + price +
                '}';
    }
}
