package com.ygj.Idao;

import com.ygj.Model.Order;
import com.ygj.Model.Product;
import com.ygj.Model.Shoppingcar;

import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public interface IdaoPro {
    List<Product> getallpro();//拿到所有商品

    List<Product> getproBytype(Product product);//拿到商品类型

    Product getonepro(int id);//拿到单个商品

    int addcar(Shoppingcar car);//添加进购物车

    int addcarSame(int id,int sum);//如果购物车中已有，则添加数量即可

    int findcarofPid(Shoppingcar shoppingcar);//判断数据库购物车中是否有该商品

    List<Shoppingcar> getcar(int id);//根据用户拿到购物车

    int createOrder(Order order);//创建订单

    int createOrderMaxid();//查询到创建订单后当前订单的id

    int insertToProInOrder(List<Shoppingcar> list,int orderMaxid);//将当前购物车要生成订单的商品插入进订单商品详情

    List<Shoppingcar> selectProByOrder(int orderid);//根据订单id来查询订单商品详细

    List<Order> findorder(int id);//根据用户拿到用户的所有订单

    List<Order> findAllorder();//管理员拿到所有的订单

    int removecar(int id);//结算购物车的时候，删除对应用户的购物车

    int removeProInCar(int id);//购物车中删除单个商品

    int removePro(int id);//管理员删除商品

    int insetPro(Product product);//管理员添加商品

    List<Product> searchPro(String pname);//模糊搜索商品
}
