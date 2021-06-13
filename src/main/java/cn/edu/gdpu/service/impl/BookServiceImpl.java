package cn.edu.gdpu.service.impl;

import cn.edu.gdpu.bean.Book;
import cn.edu.gdpu.bean.Page;
import cn.edu.gdpu.dao.BookDao;
import cn.edu.gdpu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    BookDao bookDao;

    @Override
    public boolean addBook(Book book)
    {
        int b = bookDao.addBook(book);

        return (b > 0) ? true : false;
    }

    @Override
    public Book getBookById(Integer id)
    {
        Book book = bookDao.getBookById(id);
        return book;
    }

    @Override
    public boolean updateBook(Book book)
    {
        int b = bookDao.updateBook(book);
        return (b > 0) ? true : false;
    }

    @Override
    public boolean deleteBook(Integer id)
    {
        int b = bookDao.deleteBookById(id);
        return (b > 0) ? true : false;
    }

    @Override
    public List<Book> getBooks()
    {
        return bookDao.getBooks();
    }

    @Override
    public Integer getBooksTotal()
    {
        return bookDao.getBooksTotal();
    }

    @Override
    public List<Book> getBooksByPage(Page page)
    {
        return bookDao.getBooksByPage(page);
    }

    @Override
    public Integer getBooksTotalByName(String bookname)
    {
        return bookDao.getBooksTotalByName(bookname);
    }

    @Override
    public List<Book> getBooksByName(String bookname)
    {
        return bookDao.getBooksByName(bookname);
    }

    @Override
    public List<Book> getBooksByPageAndName(Page page, String bookname)
    {
        return bookDao.getBooksByPageAndName(page, bookname);
    }
}
