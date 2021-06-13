package dao;

import cn.edu.gdpu.bean.User;
import cn.edu.gdpu.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest
{
    UserDao userDao;

    @Before
    public void test()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
        userDao = (UserDao) applicationContext.getBean("userDao");
    }

    @Test
    public void getUserById()
    {
        System.out.println(userDao.getUserById(2));
    }

    @Test
    public void updateUser()
    {
        User user = new User(3, "tom123", "12367");
        System.out.println(userDao.updateUser(user));
    }

    @Test
    public void addUser()
    {
        System.out.println(userDao.addUser(new User(null, "tom1", "123")));
    }

    @Test
    public void deleteUserById()
    {
        System.out.println(userDao.deleteUserById(3));
    }

    @Test
    public void getUsers()
    {
        System.out.println(userDao.getUsers());
    }

    @Test
    public void getUserByUsernameAndPassword()
    {
        System.out.println(userDao.getUserByUsernameAndPassword("tom", "1234or1=1"));
    }

    @Test
    public void getUserByUsername()
    {
        System.out.println(userDao.getUserByUsername("tom"));
    }

    @Test
    public void getUserIdByName()
    {
        System.out.println(userDao.getUserIdByName("tom1"));
        System.out.println("git");
        System.out.println("git1");
        System.out.println("hotfixgit");
        System.out.println("hotfixtest");
    }
}