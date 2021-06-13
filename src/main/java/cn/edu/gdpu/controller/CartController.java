package cn.edu.gdpu.controller;

import cn.edu.gdpu.bean.Book;
import cn.edu.gdpu.bean.Cart;
import cn.edu.gdpu.bean.CartItem;
import cn.edu.gdpu.service.BookService;
import cn.edu.gdpu.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("/cartservlet")
@Controller
public class CartController
{
    @Autowired
    BookService bookService;

    @RequestMapping("/add")
    public void add(Integer id,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        Book book = bookService.getBookById(id);
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice(), book.getImagepath(), book.getAuthor());

        if (cart == null)//第一次使用购物车
        {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(item);
        response.sendRedirect(request.getHeader("Referer"));
    }
    @RequestMapping("/delete")
    public void delete(Integer id,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.deleteItem(id);
        response.sendRedirect(request.getHeader("Referer"));
    }

    @RequestMapping("/clear")
    public void clear(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.clear();
        response.sendRedirect(request.getHeader("Referer"));
    }
    @RequestMapping("/updateItem")
    public void updateItem(Integer id,Integer count,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        Book book = bookService.getBookById(id);
        CartItem item = new CartItem(book.getId(), book.getName(), count, book.getPrice(), MyUtils.mul(count, book.getPrice()), book.getImagepath(), book.getAuthor());

        cart.updateItemCount(item);
        response.sendRedirect(request.getHeader("Referer"));
    }
}
