package com.ygj.Model;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class Shoppingcar {
    private int id;
    private Product p;
    private int sum;
    private User uid;

    public Shoppingcar() {
    }
    public Shoppingcar(Product p, int sum,User uid) {
        this.p = p;
        this.sum = sum;
        this.uid=uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

}
