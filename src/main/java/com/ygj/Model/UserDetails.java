package com.ygj.Model;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class UserDetails {
    private String address;
    /*
    * 地址
    */

    private User user;
    /*
     * 绑定用户
     */

    public UserDetails() {
    }

    public UserDetails(String address, User user) {
        this.address = address;
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
