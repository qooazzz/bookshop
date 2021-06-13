package cn.edu.gdpu.controller;

import cn.edu.gdpu.bean.Cart;
import cn.edu.gdpu.bean.Order;
import cn.edu.gdpu.bean.OrderItem;
import cn.edu.gdpu.bean.User;
import cn.edu.gdpu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequestMapping("/orderservlet")
@Controller
public class OrderController
{
    @Autowired
    OrderService orderService;

    @RequestMapping("/createOrder")
    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException//生成订单
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if (user == null)
        {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
            return;
        }
        Order order = orderService.addOrder(cart, user.getId());
        if (order == null)
        {
            System.out.println("订单创建失败！");
            return;
        }
        else
        {
            session.setAttribute("order", order);
            session.removeAttribute("cart");
            response.sendRedirect("/book/pages/checkout/checkout.jsp");
        }
    }

    @RequestMapping("/getOrders")
    public void getOrders(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        List<Order> orders = orderService.getAllOrders();
        HttpSession session = request.getSession();
        session.setAttribute("orders", orders);
        response.sendRedirect("/book/pages/manager/manage.jsp");
    }

    @RequestMapping("/getOrderDetails")
    public void getOrderDetails(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItems = orderService.getOrderDetails(orderId);
        Order order = orderService.getOrderById(orderId);
        HttpSession session = request.getSession();
        session.setAttribute("orderdetail", order);
        session.setAttribute("orderItems", orderItems);
        response.sendRedirect("/book/pages/order/order_detail.jsp");
    }

    @RequestMapping("/getMyOrders")
    public void getMyOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
        {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
            return;
        }
        List<Order> orders = orderService.getMyOrders(user.getId());
        session.setAttribute("orders", orders);
        response.sendRedirect("/book/pages/order/user_order.jsp");
    }

    @RequestMapping("/payOrder")
    public void payOrder(String orderId,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
        {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
            return;
        }

        boolean b = orderService.payOrder(orderId);
        if (b)
        {
            List<Order> orders = orderService.getMyOrders(user.getId());//订单支付后更新session的orders方便查看所有用户订单
            session.setAttribute("orders", orders);

            Order order = (Order) session.getAttribute("order");//订单支付后更新session的order方便用户查看更新后的单个订单
            order.setStatus(1);
            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            System.out.println("支付失败");
        }

    }

    @RequestMapping("/sendOrder")
    public void sendOrder(String orderId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        boolean b = orderService.sendOrder(orderId);
        if (b)
        {
            List<Order> orders = orderService.getAllOrders();
            session.setAttribute("orders", orders);
            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            System.out.println("发货失败,订单号是:" + orderId);
        }

    }

    @RequestMapping("/receiveOrder")
    public void receiveOrder(String orderId,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();

        boolean b = orderService.receiveOrder(orderId);
        if (b)
        {
            List<Order> orders = orderService.getAllOrders();
            session.setAttribute("orders", orders);
            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            System.out.println("收货失败,订单号是:" + orderId);
        }

    }
}
