package dao;

import cn.edu.gdpu.bean.OrderItem;
import cn.edu.gdpu.dao.OrderItemDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderItemDaoTest
{
    OrderItemDao orderItemDao;

    @Before
    public void test()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
        orderItemDao = (OrderItemDao) applicationContext.getBean("orderItemDao");
    }

    @Test
    public void getOrderItemsByOrderId()
    {
        System.out.println(orderItemDao.getOrderItemsByOrderId("16219253567861"));
    }

    @Test
    public void updateOrderItem()
    {
        OrderItem orderItem = new OrderItem(1,"红楼梦",null,null,null,null);
        System.out.println(orderItemDao.updateOrderItem(orderItem));
    }

    @Test
    public void addOrderItem()
    {
        OrderItem orderItem = new OrderItem(null,"西游记",1,10.0,10.0,"16219253567861");
        System.out.println(orderItemDao.addOrderItem(orderItem));
    }

    @Test
    public void deleteOrderItemByOrderId()
    {
        System.out.println(orderItemDao.deleteOrderItemByOrderId("16219253567861"));
    }


}