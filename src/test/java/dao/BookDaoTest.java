package dao;

import cn.edu.gdpu.bean.Book;
import cn.edu.gdpu.bean.Page;
import cn.edu.gdpu.dao.BookDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookDaoTest
{
    BookDao bookDao;

    @Before
    public void test()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
        bookDao = (BookDao) applicationContext.getBean("bookDao");
    }

    @Test
    public void getBookById()
    {
        System.out.println(bookDao.getBookById(1));
    }

    @Test
    public void updateBook()
    {
        Book book = new Book();
        book.setId(2);
        book.setName("红楼梦1");
        System.out.println(bookDao.updateBook(book));
    }

    @Test
    public void addBook()
    {
        System.out.println(bookDao.addBook(new Book(null, "三国演义", "罗贯中", 10.0, null,null,"BB出版社", null)));

    }

    @Test
    public void deleteBookById()
    {
        System.out.println(bookDao.deleteBookById(12));
    }

    @Test
    public void getBooks()
    {
        System.out.println(bookDao.getBooks());
    }

    @Test
    public void getBooksByPage()
    {
        System.out.println(bookDao.getBooksByPage(new Page(1, 5, 4)));
    }

    @Test
    public void getBooksTotal()
    {
        System.out.println(bookDao.getBooksTotal());
    }

    @Test
    public void getBooksTotalByName()
    {
        System.out.println(bookDao.getBooksTotalByName("三"));
    }

    @Test
    public void getBooksByName()
    {
        System.out.println(bookDao.getBooksByName("三"));
    }

    @Test
    public void getBooksByPageAndName()
    {
        System.out.println(bookDao.getBooksByPageAndName(new Page(1,5,7), "三"));
    }
}