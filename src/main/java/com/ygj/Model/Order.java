package com.ygj.Model;

import java.util.Date;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class Order {
    private int orderid;
    private String ordernum;
    private double orderprice;
    private User orderuser;
    private String orderdatetime;
    private Flag flag;
    private UserDetails userDetails;

    public Order() {
        orderuser=new User();
    }

    public Order(String ordernum, double orderprice, User orderuser, String orderdatetime,Flag flag,UserDetails userDetails) {
        this.ordernum = ordernum;
        this.orderprice = orderprice;
        this.orderuser = orderuser;
        this.orderdatetime = orderdatetime;
        this.flag=flag;
        this.userDetails=userDetails;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    public User getOrderuser() {
        return orderuser;
    }

    public void setOrderuser(User orderusername) {
        this.orderuser = orderusername;
    }

    public String getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(String orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
