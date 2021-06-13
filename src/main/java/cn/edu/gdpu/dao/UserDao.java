package cn.edu.gdpu.dao;

import cn.edu.gdpu.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao
{
    public User getUserById(Integer id);

    public int updateUser(User user);

    public int addUser(User user);

    public int deleteUserById(Integer id);

    public List<User> getUsers();

    public User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    public User getUserByUsername(String username);

    public Integer getUserIdByName(String username);
}
