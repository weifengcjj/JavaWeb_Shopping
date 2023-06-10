package com.ygj.Idao;

import com.ygj.Model.Flag;
import com.ygj.Model.Type;
import com.ygj.Model.User;
import com.ygj.Model.UserDetails;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public interface IdaoFace {
    Set<User> getalluser();//拿到所有用户

    Set<User> getalladmin();//所有管理员

    User userlogin(User user);//判断用户登录

    User admlogin(User user);//判断管理员登录

    int insertuser(User user);//用户注册

    List<Type> getalltype();//拿到所有类型

    Type getTypeName(int id);//根据typeid，获取type名称

    int insertType(String typename);//插入类型

    int removeUser(int id);//根据id删除用户

    Map<Integer,String> getAllflag();

    int updateFlag(int id);//根据订单id，来更新订单状态

    UserDetails PersonMessageShow(User user);//根据用户查询用户详情

    int insetPersonMessage(User user);//用户注册时添加的空个人信息

    int PersonMessageUpdata(User user,String address);//根据用户来修改用户详情

    int PasswordUpdate(User user,String newpwd);//修改密码

}
