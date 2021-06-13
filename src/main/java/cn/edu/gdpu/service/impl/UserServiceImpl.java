package cn.edu.gdpu.service.impl;

import cn.edu.gdpu.bean.User;
import cn.edu.gdpu.dao.UserDao;
import cn.edu.gdpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserDao userDao ;

    @Override//登录 传入user 用户名和密码正确则成功登录
    public boolean login(User user)
    {
        return userDao.getUserByUsernameAndPassword(user.getName(), user.getPassword())!=null?true:false;
    }

    @Override //注册 传入user true代表成功注册
    public boolean regist(User user)
    {
        return userDao.addUser(user)>=1?true:false;
    }

    @Override//判断用户名是否存在 true代表用户名已存在
    public boolean isExistsUsername(String username)
    {
        return userDao.getUserByUsername(username) == null?false:true;
    }

    @Override
    public Integer getUserIdByName(String username)
    {
        return userDao.getUserIdByName(username);
    }
}
