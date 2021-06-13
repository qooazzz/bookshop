package cn.edu.gdpu.dao;

import cn.edu.gdpu.bean.OrderItem;

import java.util.List;

public interface OrderItemDao
{
    public List<OrderItem> getOrderItemsByOrderId(String orderId);

    public int updateOrderItem(OrderItem OrderItem);

    public int addOrderItem(OrderItem OrderItem);

    public int deleteOrderItemByOrderId(String orderId);

}
