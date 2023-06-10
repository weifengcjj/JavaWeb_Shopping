package com.ygj.Model;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class Product {
    private int id;
    private String name;
    private String img;
    private String desc;
    private int num;
    private double price;
    private int typeid;
    private Type type;

    public Product() {
    }

    public Product(int id, String name, String img, String desc, int num, double price,int typeid) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.desc = desc;
        this.num = num;
        this.price = price;
        this.typeid=typeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", 名字='" + name + '\'' +
                ", 图片='" + img + '\'' +
                ", 介绍='" + desc + '\'' +
                ", 数量=" + num +
                ", 价格=" + price +
                ", 类型id=" + typeid +
                '}';
    }
}
