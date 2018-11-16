package edu.whitehou.entity;

import java.io.Serializable;

/**
 * @author : white.hou
 * @description : 用户实体层 连接表user_account_msg
 * @date: 2018/11/10_19:05
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3199742564707255712L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户的学号、教职工号，唯一
     */
    private String userId;
    /**
     * 用户密码，默认为123456
     */
    private String password;
    /**
     * 用户的真实姓名
     */
    private String userName;
    /**
     * 用户的性别 0 女 1 男
     */
    private Integer gender;
    /**
     * 用户的身份标识
     */
    private String identity;
    /**
     * 用户所属学院或者部门
     */
    private String collage;
    /**
     * 用户年级或者职务/职称
     */
    private String grade;
    /**
     * 用户的电话号码
     */
    private String phone;

    public User(String userId, String password, String userName, Integer gender, String identity, String collage, String grade, String phone) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.identity = identity;
        this.collage = collage;
        this.grade = grade;
        this.phone = phone;
    }

    public User(String userId, String userName, Integer gender, String identity, String collage, String grade, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.identity = identity;
        this.collage = collage;
        this.grade = grade;
        this.phone = phone;
    }

    public User(Integer id, String userId, String userName, Integer gender, String identity, String collage, String grade, String phone) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.identity = identity;
        this.collage = collage;
        this.grade = grade;
        this.phone = phone;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentity() {
        return identity;
    }

    public Integer getGender() { return gender; }

    public void setGender(Integer gender) { this.gender = gender; }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", identity='" + identity + '\'' +
                ", collage='" + collage + '\'' +
                ", grade='" + grade + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
