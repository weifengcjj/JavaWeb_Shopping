package com.ygj.Service;

import com.ygj.Dao.Find;
import com.ygj.Idao.IdaoFace;
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
public class Service implements IdaoFace {
    @Override
    public Set<User> getalluser() {
        Set<User> alluser = Find.findAlluser();
        return alluser;
    }

    @Override
    public Set<User> getalladmin() {
        Set<User> alladmin = Find.findAlladmin();
        return alladmin;
    }

    @Override
    public User userlogin(User user) {
        User user1=Find.Userin(user);
        System.out.println("用户登录"+user1);
        if(user.getUser().equals(user1.getUser())&&user.getPassword().equals(user1.getPassword()))
        {
            return user1;
        }
        return null;
    }

    @Override
    public User admlogin(User user) {
        User user1=Find.Adminin(user);
        System.out.println("管理员登录"+user1);
        if (user.getUser().equals(user1.getUser()) && user.getPassword().equals(user1.getPassword())) {
                return user1;
        }
        return null;
    }

    @Override
    public int insertuser(User user) {
        int insert = Find.insert(user);
        return insert;
    }

    @Override
    public List<Type> getalltype() {
        List<Type> list = Find.getallType();
        return list;
    }

    @Override
    public Type getTypeName(int id) {
        Type type = Find.getTypeName(id);
        return type;
    }

    @Override
    public int insertType(String typename) {
        int i = Find.insertType(typename);
        return i;
    }

    @Override
    public int removeUser(int id) {
        int i = Find.removeUser(id);
        return i;
    }

    @Override
    public Map<Integer, String> getAllflag() {
        Map<Integer, String> allflag = Find.getAllflag();
        return allflag;
    }

    @Override
    public int updateFlag(int id) {
        int i = Find.updateFlag(id);
        return i;
    }

    @Override
    public UserDetails PersonMessageShow(User user) {
        UserDetails userDetails = Find.PersonMessageShow(user);
        return userDetails;
    }

    @Override
    public int insetPersonMessage(User user) {
        int i = Find.insetPersonMessage(user);
        return i;
    }

    @Override
    public int PersonMessageUpdata(User user, String address) {
        int i = Find.PersonMessageUpdata(user, address);
        return i;
    }

    @Override
    public int PasswordUpdate(User user, String newpwd) {
        int i = Find.PasswordUpdate(user, newpwd);
        return i;
    }

}
