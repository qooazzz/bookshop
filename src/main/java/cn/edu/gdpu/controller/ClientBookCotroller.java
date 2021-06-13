package cn.edu.gdpu.controller;

import cn.edu.gdpu.bean.Book;
import cn.edu.gdpu.bean.Page;
import cn.edu.gdpu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("/client/bookservlet")
@Controller
public class ClientBookCotroller
{
    @Autowired
    BookService bookService;

    @RequestMapping("/page")
    public void page(Integer pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Page page = new Page();
        Integer pageSize = 6;
        Integer booksTotal = bookService.getBooksTotal();//获取记录数
        Integer pageTotal = 0;//总页码

        if (booksTotal % pageSize > 0)//给总页码赋值
            pageTotal = booksTotal / pageSize + 1;
        else
            pageTotal = booksTotal / pageSize;

        if (pageNo != null)
        {
            if (pageNo < 1)//如果为空则默认为首页
                page = new Page(1, pageTotal, pageSize);
            else if (pageNo > pageTotal)
                page = new Page(pageTotal, pageTotal, pageSize);
            else
                page = new Page(pageNo, pageTotal, pageSize);
        }
        else
            page = new Page(1, pageTotal, pageSize);
        page.setUrl("/book/client/bookservlet?action=page");
        List<Book> books = bookService.getBooksByPage(page);
        request.setAttribute("books", books);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    @RequestMapping("/pageByName")
    public void pageByName(String key, Integer pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Page page = new Page();
        Integer pageSize = 6;
        Integer booksTotal = bookService.getBooksTotalByName(key);//获取记录数
        Integer pageTotal = 0;//总页码

        if (booksTotal % pageSize > 0)//计算总页码
            pageTotal = booksTotal / pageSize + 1;
        else
            pageTotal = booksTotal / pageSize;

        if (pageNo != null)//如果没指定页数 则默认第一页
        {
            if (pageNo < 1)//如果为空则默认为首页
                page = new Page(1, pageTotal, pageSize);
            else if (pageNo > pageTotal)
                page = new Page(pageTotal, pageTotal, pageSize);
            else
                page = new Page(pageNo, pageTotal, pageSize);
        }
        else
            page = new Page(1, pageTotal, pageSize);

        page.setUrl("/book/client/bookservlet?action=pageByName&key=" + key);
        List<Book> books = bookService.getBooksByPageAndName(page, key);
        request.setAttribute("books", books);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
