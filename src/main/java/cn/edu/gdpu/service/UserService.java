package cn.edu.gdpu.service;


import cn.edu.gdpu.bean.User;

public interface UserService
{

    /**
     * 登录
     *
     * @param user 传入User
     * @return true则代表登录成功
     */
    public boolean login(User user);

    /**
     * 注册
     *
     * @param user 传入Use
     * @return true则代表注册成功
     */
    public boolean regist(User user);

    /**
     * 查看该用户名是否存在
     *
     * @param username
     * @return true则用该户名代表存在
     */

    public boolean isExistsUsername(String username);

    public Integer getUserIdByName(String username);
}
