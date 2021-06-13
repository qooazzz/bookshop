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

@RequestMapping("/bookservlet")
@Controller
public class BookController
{
    @Autowired
    BookService bookService;

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        List<Book> books = bookService.getBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/pages/manager/book_manage.jsp").forward(request, response);
    }

    @RequestMapping("/getBookById")
    public void getBookById(Integer id, String pageNo, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Book book = bookService.getBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNo=" + pageNo).forward(request, response);
    }

    @RequestMapping("/update")
    public void update(Book book, String pageNo, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        boolean b = bookService.updateBook(book);
        if (b)//更新成功
        {
            response.sendRedirect("/book/bookservlet?action=page&pageNo=" + pageNo);
        }
        else
        {
            System.out.println("更新失败");
        }

    }

    @RequestMapping("/delete")
    public void delete(Integer id, String pageNo, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        boolean b = bookService.deleteBook(id);
        if (b)
        {
            response.sendRedirect("/book/bookservlet?action=page&pageNo=" + pageNo);
        }
        else
        {
            System.out.println("删除失败");
        }
    }

    @RequestMapping("/add")
    public void add(Book book, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        boolean b = bookService.addBook(book);

        Integer booksTotal = bookService.getBooksTotal();//获取记录数
        Integer pageTotal = 0;//总页码
        if (booksTotal % Page.PAGE_SIZE > 0)//给总页码赋值
            pageTotal = booksTotal / Page.PAGE_SIZE + 1;
        else
            pageTotal = booksTotal / Page.PAGE_SIZE;

        if (b)//添加成功
        {
            response.sendRedirect("/book/bookservlet?action=page&pageNo=" + pageTotal);
        }
        else
            System.out.println("添加失败");
    }

    @RequestMapping("/page")
    public void page(Integer pageNo, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Page page = new Page();
        Integer pageSize = 4;
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

        List<Book> books = bookService.getBooksByPage(page);
        request.setAttribute("books", books);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manage.jsp").forward(request, response);
    }

}
