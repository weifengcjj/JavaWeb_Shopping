package com.ygj.Service;

import com.ygj.Dao.Find;
import com.ygj.Dao.ProDao;
import com.ygj.Idao.IdaoPro;
import com.ygj.Model.Order;
import com.ygj.Model.Product;
import com.ygj.Model.Shoppingcar;
import com.ygj.Model.Type;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class ProService implements IdaoPro {
    Service ss=new Service();
    @Override
    public List<Product> getallpro() {
        List<Product> list=ProDao.getallpro();
//        for (Product product : list) {
//            System.out.println(product);
//            product.setImg("image\\"+product.getImg()+"");
//        }
        for (Product product : list) {
            System.out.println(product.getImg());
            product.setType(ss.getTypeName(product.getTypeid()));
        }
        return list;
    }

    @Override
    public List<Product> getproBytype(Product product) {
        List<Product> list=ProDao.getpro(product);
        return list;
    }

    @Override
    public Product getonepro(int id) {
        Product getonepro = ProDao.getonepro(id);
        return getonepro;
    }

    @Override
    public int addcar(Shoppingcar car) {
        int add=0;
        try {
            add = ProDao.addcar(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return add;
    }

    @Override
    public int addcarSame(int pid, int sum) {
        int i = ProDao.addcarSame(pid, sum);
        return i;
    }

    @Override
    public int findcarofPid(Shoppingcar shoppingcar) {
        int s = ProDao.findcarofPid(shoppingcar);
        System.out.println("数据库购物车对应id查的确实有: "+s);
            //System.out.println("数据库的pid："+s.getP().getId()+"------"+"添加的商品pid："+shoppingcar.getP().getId());
//            if(s.getP().getId()==shoppingcar.getP().getId())
//            {
//                return s;
//            }
        return s;
    }

    @Override
    public List<Shoppingcar> getcar(int id) {
        List<Shoppingcar> findcar = ProDao.findcar(id);
        return findcar;
    }

    @Override
    public int createOrder(Order order) {
        int createOrder = ProDao.createOrder(order);
        return createOrder;
    }

    @Override
    public int createOrderMaxid() {
        int orderMaxid = ProDao.createOrderMaxid();
        return orderMaxid;
    }

    @Override
    public int insertToProInOrder(List<Shoppingcar> list, int orderMaxid) {
        int i = ProDao.insertToProInOrder(list, orderMaxid);
        return i;
    }

    @Override
    public List<Shoppingcar> selectProByOrder(int orderid) {
        List<Shoppingcar> shoppingcars = ProDao.selectProByOrder(orderid);
        return shoppingcars;
    }

    @Override
    public List<Order> findorder(int id) {
        List<Order> findorder = ProDao.findorder(id);

        for (Order order : findorder) {
            order.setFlag(Find.getFlag(order.getFlag().getId()));//根据订单状态flagid，获取flag状态
        }
//        if(findorder!=null&&!findorder.isEmpty())
//        {
//            return findorder;
//        }
        if(findorder.size()!=0)
        {
            return findorder;
        }
        return null;
    }

    @Override
    public List<Order> findAllorder() {
        List<Order> allorder = ProDao.findAllorder();
        for (Order order : allorder) {
            order.setFlag(Find.getFlag(order.getFlag().getId()));//根据订单状态flagid，获取flag状态
        }
        return allorder;
    }

    @Override
    public int removecar(int id) {
        int removecar = ProDao.removecar(id);
        return removecar;
    }

    @Override
    public int removeProInCar(int id) {
        int i = ProDao.removeProInCar(id);
        return i;
    }

    @Override
    public int removePro(int id) {
        int i = ProDao.removePro(id);
        return i;
    }

    @Override
    public int insetPro(Product product) {
        int i = ProDao.insetPro(product);
        return i;
    }

    @Override
    public List<Product> searchPro(String pname) {
        List<Product> list=ProDao.searchPro(pname);
        for (Product product : list) {
            System.out.println(product.getName());
        }
        return list;
    }
}
