package cn.edu.gdpu.dao;

import cn.edu.gdpu.bean.Book;
import cn.edu.gdpu.bean.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao
{
    public Book getBookById(Integer id);

    public int updateBook(Book book);

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public List<Book> getBooks();

    public List<Book> getBooksByPage(Page page);

    public Integer getBooksTotal();

    public Integer getBooksTotalByName(String bookname);

    public List<Book> getBooksByName(String bookname);

    public List<Book> getBooksByPageAndName(@Param("page") Page page, @Param("bookname") String bookname);
}
