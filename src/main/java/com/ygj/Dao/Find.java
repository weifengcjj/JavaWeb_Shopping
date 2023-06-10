package com.ygj.Dao;

import com.mysql.cj.MysqlxSession;
import com.ygj.Model.*;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Find {
    static public User Userin(User user)//查找是否存在此用户
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        User user1=new User();
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql ="select * from user where username='"+user.getUser()+"'and  password='"+user.getPassword()+"'";
            rs=st.executeQuery(sql);
                while (rs.next())
                {
                    user1.setId(rs.getInt("id"));
                    user1.setUser(rs.getString("username"));
                    user1.setPassword(rs.getString("password"));
                    user1.setDatetime(rs.getString("datetime"));
                    user1.setEmail(rs.getString("email"));
                }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return user1;
    }
    static public User Adminin(User user)//查找是否存在此用户
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        User user1=new User();
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql ="select * from admin where username='"+user.getUser()+"'and  password='"+user.getPassword()+"'";
            rs=st.executeQuery(sql);
                while (rs.next()) {
                    user1.setUser(rs.getString("username"));
                    user1.setPassword(rs.getString("password"));
                    user1.setDatetime(rs.getString("datetime"));
                }
                System.out.println("数据库的管理员"+user1.getUser()+"管理员密码:"+user1.getPassword());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return user1;

    }
    static public Set<User> findAlluser()//查找所有用户
    {
        Set<User> list=new HashSet<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from user";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setUser(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setDatetime(rs.getString("datetime"));
                u.setEmail(rs.getString("email"));
                list.add(u);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }
    static public Set<User> findAlladmin()//查找所有管理员
    {
        Set<User> list=new HashSet<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from admin";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                User u=new User();
                u.setUser(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setDatetime(rs.getString("datetime"));
                list.add(u);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }

    static public ArrayList<Product> findAll()//拿到所有商品
    {
        ArrayList<Product> list=new ArrayList();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con=Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from product";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImg((rs.getString("img")));
                p.setDesc(rs.getString("desc"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                System.out.println(p.getName());
                list.add(p);
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }

    public Product findByid(int id)//根据id查询商品
    {
        Product p=new Product();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="select * from product where id="+id+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImg((rs.getString("img")));
                p.setDesc(rs.getString("desc"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  p;
    }
     static public int insert(User user) {//注册
         Connection con=null;
         Statement st=null;
         ResultSet rs=null;
         con= Jdbc.getcon();
         Date date=new Date(System.currentTimeMillis());
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         System.out.println(formatter.format(date));
         PreparedStatement sql = null;
         try {
             st= con.createStatement();
             sql = con.prepareStatement("insert into user(username,password,datetime,email)values(?,?,?,?)");
             String sql1="select max(id) from user";
             sql.setString(1, user.getUser());
             sql.setString(2, user.getPassword());
             sql.setString(3, formatter.format(date));
             sql.setString(4,user.getEmail());
             int rtn = sql.executeUpdate();
             rs=st.executeQuery(sql1);
             while (rs.next())
             {
                 System.out.println(rs.getInt("max(id)"));
             }
             sql.close();
             con.close();
             return 1;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         finally {
             Jdbc.closeAll(con,st,rs);
         }
         return 0;
    }

    public static List<Type> getallType()
    {
        List<Type> list=new ArrayList<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="SELECT * FROM type";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                Type type=new Type();
                type.setTypeId(rs.getInt("typeId"));
                type.setTypeName(rs.getString("typeName"));
                list.add(type);
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  list;
    }
    public static Type getTypeName(int id)
    {
        Type type=new Type();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="SELECT * FROM type where typeId="+id+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                type.setTypeId(rs.getInt("typeId"));
                type.setTypeName(rs.getString("typeName"));
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  type;
    }
    static public int insertType(String typename){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        PreparedStatement sql = null;
        int rtn=0;
        try {
            sql = con.prepareStatement("insert into type(typeName) values (?)");
            sql.setString(1,typename);
            rtn = sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
    static public int removeUser(int id)
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con= Jdbc.getcon();
        try {
            PreparedStatement sql0=con.prepareStatement("SET Foreign_key_checks=0;");
            PreparedStatement sql1 = con.prepareStatement("delete from user where id = "+id+";");
            PreparedStatement sql2=con.prepareStatement("SET Foreign_key_checks=1;");
            PreparedStatement sql3=con.prepareStatement("set @i=0;\n" +
                    "update product set product.id=(@i:=@i+1);");
            rtn = sql1.executeUpdate();
            sql0.close();
            sql1.close();
            sql2.close();
            sql3.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }
    static public Map<Integer,String> getAllflag()//没用到
    {
       Map<Integer,String> map=new HashMap<>();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="SELECT * FROM flag";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                map.put(rs.getInt("id"),rs.getString("flagName"));
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  map;
    }
    static public Flag getFlag(int id)
    {
        Flag flag=new Flag();
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql="SELECT * FROM flag where id="+id+"";
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                flag.setId(rs.getInt("id"));
                flag.setFlagName(rs.getString("flagName"));
                flag.setFlagButton(rs.getString("flagButton"));
            }
        } catch (SQLException  exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return  flag;
    }
    static public int updateFlag(int id)//更新状态
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con= Jdbc.getcon();
        try {
            PreparedStatement sql=con.prepareStatement("update orderall set flagid=flagid+1 where orderid="+id+";");
            rtn = sql.executeUpdate();
            sql.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
    static public UserDetails PersonMessageShow(User user)//根据用户查询用户详情
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        User u=new User();
        UserDetails ud=new UserDetails();
        try {
            con= Jdbc.getcon();
            st=con.createStatement();
            String sql ="SELECT id,username,password,datetime,email,address FROM `user` INNER JOIN userdetails\n" +
                    "\n" +
                    "on `user`.id="+user.getId()+" and userdetails.uid="+user.getId()+"";
            rs=st.executeQuery(sql);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUser(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setDatetime(rs.getString("datetime"));
                u.setEmail(rs.getString("email"));
                ud.setAddress(rs.getString("address"));
                ud.setUser(u);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            Jdbc.closeAll(con,st,rs);
        }
        return ud;

    }
    static public int  insetPersonMessage(User user)
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        con=Jdbc.getcon();
        PreparedStatement sql = null;
        int rtn=0;
        try {
            sql = con.prepareStatement("INSERT INTO userdetails(uid) value(?)");
            sql.setInt(1,user.getId());
            rtn = sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    static public int PersonMessageUpdata(User user,String address)//根据用户来修改用户详情
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con=Jdbc.getcon();
        PreparedStatement sql= null;
        try {
            sql = con.prepareStatement("update userdetails set address=\""+address+"\" where uid="+user.getId()+"");
            rtn= sql.executeUpdate();
            sql.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return rtn;
    }
    static public int PasswordUpdate(User user,String newpwd)//修改密码
    {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int rtn=0;
        con=Jdbc.getcon();
        PreparedStatement sql= null;
        try {
            sql = con.prepareStatement("update user set password=\""+newpwd+"\" where id="+user.getId()+"");
            rtn= sql.executeUpdate();
            sql.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

}
