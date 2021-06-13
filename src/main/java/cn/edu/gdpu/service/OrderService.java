package cn.edu.gdpu.service;

import cn.edu.gdpu.bean.Cart;
import cn.edu.gdpu.bean.Order;
import cn.edu.gdpu.bean.OrderItem;

import java.util.List;

public interface OrderService
{
    public Order addOrder(Cart cart, Integer userId);

    public List<Order> getAllOrders();

    public List<OrderItem> getOrderDetails(String orderId);

    public List<Order> getMyOrders(Integer userId);

    public boolean payOrder(String orderId);

    public boolean sendOrder(String orderId);

    public boolean receiveOrder(String orderId);

    public Order getOrderById(String orderId);

}
