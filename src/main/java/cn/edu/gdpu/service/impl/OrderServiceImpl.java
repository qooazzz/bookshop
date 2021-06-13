package cn.edu.gdpu.service.impl;

import cn.edu.gdpu.bean.Cart;
import cn.edu.gdpu.bean.CartItem;
import cn.edu.gdpu.bean.Order;
import cn.edu.gdpu.bean.OrderItem;
import cn.edu.gdpu.dao.OrderDao;
import cn.edu.gdpu.dao.OrderItemDao;
import cn.edu.gdpu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public Order addOrder(Cart cart, Integer userId)//新增订单
    {
        Order order = new Order();
        String orderId = System.currentTimeMillis() + "" + userId;

        order.setId(orderId);//订单编号
        order.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//下单时间
        order.setPrice(cart.getTotalPrice());//订单总价
        order.setStatus(0);//订单状态
        order.setUserId(userId);//用户编号

        int resulet = orderDao.addOrder(order);
        if (resulet>0)
            System.out.println("成功");
        else
        {
            System.out.println("订单创建失败,用户编号是" + userId);
            return null;
        }
        Map<Integer, CartItem> cartItems = cart.getCartItems();
        for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet())
        {
            OrderItem orderItem = new OrderItem();

            orderItem.setId(null);//订单项编号
            orderItem.setName(entry.getValue().getName());//商品名称
            orderItem.setCount(entry.getValue().getCount());//商品数量
            orderItem.setPrice(entry.getValue().getPrice());//商品单价
            orderItem.setTotalPrice(entry.getValue().getTotalPrice());//商品总价
            orderItem.setOrderId(orderId);//订单编号

            resulet = orderItemDao.addOrderItem(orderItem);
            if (resulet<=0)
            {
                System.out.println("订单项创建失败,订单项名是" + entry.getValue().getName());
                return null;
            }
        }

        return order;
    }

    @Override
    public List<Order> getAllOrders()//获取所有订单
    {
        return orderDao.getOrders();
    }

    @Override
    public List<OrderItem> getOrderDetails(String orderId)
    {
        return orderItemDao.getOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> getMyOrders(Integer userId)
    {
        return orderDao.getOrderByUserId(userId);
    }

    @Override
    public boolean payOrder(String orderId)//用户支付订单
    {
        return orderDao.updateOrder(new Order(orderId,null,null,null,null,1))>=1?true:false;
    }

    @Override
    public boolean sendOrder(String orderId)//商家发货
    {
        return orderDao.updateOrder(new Order(orderId,null,null,null,null,2))>=1?true:false;
    }

    @Override
    public boolean receiveOrder(String orderId)//用户签收商品
    {
        return orderDao.updateOrder(new Order(orderId,null,null,null,null,3))>=1?true:false;
    }

    @Override
    public Order getOrderById(String orderId)
    {
        return orderDao.getOrderById(orderId);
    }
}
