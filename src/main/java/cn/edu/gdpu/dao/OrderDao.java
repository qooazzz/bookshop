package cn.edu.gdpu.dao;

import cn.edu.gdpu.bean.Order;

import java.util.List;

public interface OrderDao
{
    public Order getOrderById(String id);

    public int updateOrder(Order order);

    public int addOrder(Order order);

    public int deleteOrderById(String id);

    public List<Order> getOrders();

    public List<Order> getOrderByUserId(Integer userId);

}
