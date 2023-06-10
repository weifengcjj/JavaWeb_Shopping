package com.ygj.Dao;

import com.ygj.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class ProDao {
    static public List<Product> getpro(Product product) {
        List<Product> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        try {
            st=con.createStatement();
            String sql="select * from product where type = "+product.getTypeid()+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                //p.setImg("image\\"+rs.getString("img"));
                p.setImg("image/"+rs.getString("img"));
                p.setDesc(rs.getString("desc"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                p.setTypeid(rs.getInt("type"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return list;
    }
    static  public List<Product> getallpro()
    {
        List<Product> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        try {
            st=con.createStatement();
            String sql="select * from product";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImg("image\\"+rs.getString("img"));
                //p.setImg("F:\\java\\YGJTest\\target\\classes\\"+rs.getString("img"));
                p.setDesc(rs.getString("desc"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                p.setTypeid(rs.getInt("type"));
                p.setPrice(rs.getDouble("price"));
                list.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return list;
    }
    static  public Product getonepro(int id)
    {
        Product p=new Product();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        try {
            st=con.createStatement();
            String sql="SELECT * FROM `product` where id="+id+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                //p.setImg("image\\"+rs.getString("img"));
                p.setImg("image\\"+rs.getString("img"));
                p.setDesc(rs.getString("desc"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                p.setTypeid(rs.getInt("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return p;
    }
    static public  int addcar(Shoppingcar car) throws  SQLException {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con= Jdbc.getcon();
        PreparedStatement sql = con.prepareStatement("insert into car(name,img,`desc`,price,sum,uid,pid)values(?,?,?,?,?,?,?)");
        sql.setString(1, car.getP().getName());
        sql.setString(2, car.getP().getImg());
        sql.setString(3, car.getP().getDesc());
        sql.setDouble(4, car.getP().getPrice());
        sql.setInt(5, car.getSum());
        sql.setInt(6,car.getUid().getId());
        sql.setInt(7,car.getP().getId());
        int rtn = sql.executeUpdate();
        sql.close();
        con.close();
        return rtn;
    }
    static public int addcarSame(int pid,int sum){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con= Jdbc.getcon();
        try {
            PreparedStatement sql=con.prepareStatement("update car set sum=sum+"+sum+" where pid="+pid+";");
            rtn = sql.executeUpdate();
            sql.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
    static public int findcarofPid(Shoppingcar shoppingcar)//根据商品id从购物车中拿，如果一样的商品，添加数量
    {
        int rtn=0;
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select count(1) from car where pid="+shoppingcar.getP().getId()+" and uid="+shoppingcar.getUid().getId()+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                rtn=rs.getInt("count(1)");
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return rtn;

    }
    static public List<Shoppingcar> findcar(int id)//根据用户拿到购物车
    {
        List<Shoppingcar> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from car where uid="+id+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Product p=new Product();
                Shoppingcar car=new Shoppingcar();
                car.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImg(rs.getString("img"));
                p.setDesc(rs.getString("desc"));
                p.setPrice(rs.getDouble("price"));
                p.setId(rs.getInt("pid"));
                car.setP(p);
                car.setSum(rs.getInt("sum"));
                list.add(car);
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }

    static public int createOrder(Order order){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        PreparedStatement sql = null;
        int rtn=0;
        try {
            sql = con.prepareStatement("insert into orderall(ordernum,orderprice,orderusername,orderdatetime,uid,flagid,address)values(?,?,?,?,?,?,?)");
            sql.setString(1,order.getOrdernum());
            sql.setDouble(2,order.getOrderprice());
            sql.setString(3,order.getOrderuser().getUser());
            sql.setString(4,order.getOrderdatetime());
            sql.setInt(5,order.getOrderuser().getId());
            sql.setInt(6,order.getFlag().getId());
            sql.setString(7,order.getUserDetails().getAddress());
            rtn = sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    static public int createOrderMaxid()//查询到创建订单后当前订单的id
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        int rtn=0;
        try {
            st= con.createStatement();
            String sql1="select max(orderid) from orderall";
            rs=st.executeQuery(sql1);
            while (rs.next())
            {
               rtn=rs.getInt("max(orderid)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
    static public int insertToProInOrder(List<Shoppingcar> list,int orderMaxid)//将当前购物车要生成订单的商品插入进订单商品详情
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        PreparedStatement sql = null;
        int rtn=0;
        try {
            for (Shoppingcar s : list) {
                sql = con.prepareStatement("insert into productinorder(pid,pname,pimg,pdesc,pnum,pprice,oid)values(?,?,?,?,?,?,?)");
                sql.setInt(1,s.getP().getId());
                sql.setString(2,s.getP().getName());
                sql.setString(3,s.getP().getImg());
                sql.setString(4,s.getP().getDesc());
                sql.setInt(5,s.getSum());
                sql.setDouble(6,s.getP().getPrice());
                sql.setInt(7,orderMaxid);
                rtn = sql.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    static public List<Shoppingcar> selectProByOrder(int orderid)//根据订单id来查询订单商品详细
    {
        List<Shoppingcar> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from productinorder where oid="+orderid+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Product p=new Product();
                Shoppingcar car=new Shoppingcar();
                p.setId(rs.getInt("pid"));
                p.setName(rs.getString("pname"));
                p.setImg(rs.getString("pimg"));
                p.setDesc(rs.getString("pdesc"));
                car.setSum(rs.getInt("pnum"));
                p.setPrice(rs.getDouble("pprice"));
                car.setP(p);
                list.add(car);
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }

    static public List<Order> findorder(int id)//根据用户拿到用户的所有订单
    {
        List<Order> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from orderall where uid="+id+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Order order=new Order();
                Flag f=new Flag();
                UserDetails ud=new UserDetails();
                order.setFlag(f);
                order.setUserDetails(ud);
                order.setOrderid(rs.getInt("orderid"));
                order.setOrdernum(rs.getString("ordernum"));
                order.setOrderprice(rs.getDouble("orderprice"));
                order.getOrderuser().setUser(rs.getString("orderusername"));
                order.setOrderdatetime(rs.getString("orderdatetime"));
                order.getOrderuser().setId(rs.getInt("uid"));
                order.getFlag().setId(rs.getInt("flagid"));
                order.getUserDetails().setAddress(rs.getString("address"));
                list.add(order);
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }
    static public List<Order> findAllorder()//根据用户拿到用户的所有订单
    {
        List<Order> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from orderall";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Order order=new Order();
                Flag f=new Flag();
                order.setFlag(f);
//                User user=new User();
//                order.setOrderuser(user);
                order.setOrderid(rs.getInt("orderid"));
                order.setOrdernum(rs.getString("ordernum"));
                order.setOrderprice(rs.getDouble("orderprice"));
                System.out.println("数据库的值name--"+rs.getString("orderusername"));
                System.out.println("getuser是什么--"+order.getOrderuser().getUser());
                order.getOrderuser().setUser(rs.getString("orderusername"));
                order.setOrderdatetime(rs.getString("orderdatetime"));
                order.getOrderuser().setId(rs.getInt("uid"));
                order.getFlag().setId(rs.getInt("flagid"));
                list.add(order);
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }
    static public int removecar(int id)
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con= Jdbc.getcon();
        try {
            PreparedStatement sql = con.prepareStatement("delete from car where uid = "+id+"");
            rtn = sql.executeUpdate();
            sql.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
    static public int removeProInCar(int id)
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con= Jdbc.getcon();
        try {
            PreparedStatement sql = con.prepareStatement("delete from car where id = "+id+"");
            PreparedStatement sql1=con.prepareStatement("set @i=0;\n" +
                    "update product set product.id=(@i:=@i+1);");
            rtn = sql.executeUpdate();
            sql.close();
            sql1.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
    static public int removePro(int id)
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con= Jdbc.getcon();
        try {
            PreparedStatement sql = con.prepareStatement("delete from product where id = "+id+"");
            PreparedStatement sql1=con.prepareStatement("set @i=0;\n" +
                    "update product set product.id=(@i:=@i+1);");
            rtn = sql.executeUpdate();
            sql.close();
            sql1.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
    static public int insetPro(Product product){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        PreparedStatement sql = null;
        int rtn=0;
        try {
            sql = con.prepareStatement("insert into product(product.`name`,img,product.`desc`,num,price,type)values(?,?,?,?,?,?)");
            sql.setString(1,product.getName());
            sql.setString(2,product.getImg());
            sql.setString(3,product.getDesc());
            sql.setInt(4,product.getNum());
            sql.setDouble(5,product.getPrice());
            sql.setInt(6,product.getType().getTypeId());
            rtn = sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    static public List<Product> searchPro(String pname)
    {
        List<Product> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        try {
            st=con.createStatement();
            String sql="SELECT * FROM `product` where `name` like \"%"+pname+"%\"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImg("image\\"+rs.getString("img"));
                //p.setImg("F:\\java\\YGJTest\\target\\classes\\"+rs.getString("img"));
                p.setDesc(rs.getString("desc"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                p.setTypeid(rs.getInt("type"));
                p.setPrice(rs.getDouble("price"));
                list.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return list;
    }



}
