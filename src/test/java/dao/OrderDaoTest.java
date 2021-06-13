package dao;

import cn.edu.gdpu.bean.Order;
import cn.edu.gdpu.dao.OrderDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDaoTest
{
    OrderDao orderDao;

    @Before
    public void test()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
        orderDao = (OrderDao) applicationContext.getBean("orderDao");
    }

    @Test
    public void getOrderById()
    {
        System.out.println(orderDao.getOrderById("16219253567861"));
    }

    @Test
    public void updateOrder()
    {
        String id="16219253567861";
        String createTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Order order=new Order(id,createTime,null,null,null,0);
        System.out.println(orderDao.updateOrder(order));
    }

    @Test
    public void addOrder()
    {
        String id=System.currentTimeMillis()+""+1;
        String createTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Order order=new Order(id,createTime,createTime,10.0,1,0);
        System.out.println(orderDao.addOrder(order));
    }

    @Test
    public void deleteOrderById()
    {
        System.out.println(orderDao.deleteOrderById("16219250192951"));
    }

    @Test
    public void getOrders()
    {
        System.out.println(orderDao.getOrders());
    }

    @Test
    public void getOrderByUserId()
    {
        System.out.println(orderDao.getOrderByUserId(1));
    }
}