package edu.whitehou.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author : white.hou
 * @description : 管理员信息实体层，连接表root_account_msg,只能由超级管理员进行crud操作
 * @date: 2018/11/10_18:58
 */
public class Root implements Serializable {
    private static final long serialVersionUID = 5754974987243948245L;
    /**
     * 序号id 主键 自增
     */
    private Integer id;

    /**
     * 用户名
     */
    private String rootName;
    /**
     * 密码,md5盐值加密
     */
    private String password;
    /**
     * 管理员身份，admin：root超级管理员  user:root 用户管理员  order:root 订单管理员 product:root 产品管理员
     */
    private  String identity;
    /**
     * 创建时间
     */
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", rootName='" + rootName + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", date=" + date +
                '}';
    }
}
