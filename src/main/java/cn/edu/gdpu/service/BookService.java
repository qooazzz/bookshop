package cn.edu.gdpu.service;

import cn.edu.gdpu.bean.Book;
import cn.edu.gdpu.bean.Page;

import java.util.List;

public interface BookService
{
    public boolean addBook(Book book);

    public Book getBookById(Integer id);

    public boolean updateBook(Book book);

    public boolean deleteBook(Integer id);

    public List<Book> getBooks();

    public Integer getBooksTotal();//获取记录数

    public List<Book> getBooksByPage(Page page);

    public Integer getBooksTotalByName(String bookname);//获取搜索结果的记录数

    public List<Book> getBooksByName(String bookname);

    public List<Book> getBooksByPageAndName(Page page,String bookname);

}
