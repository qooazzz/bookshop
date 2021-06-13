package cn.edu.gdpu.bean;

import cn.edu.gdpu.utils.MyUtils;

public class CartItem
{
    private Integer id;//商品编号
    private String name;
    private Integer count;//数量
    private Double price;//单价
    private Double totalPrice;//总价
    private String imagepath = "static/img/book/default.jpg";
    private String author;

    public CartItem()
    {

    }

    public CartItem(Book book)//将一本书添加商品项
    {
        this.id = book.getId();
        this.name = book.getName();
        this.count = 1;
        this.price = book.getPrice();
        this.totalPrice = book.getPrice();
        this.imagepath = book.getImagepath();
        this.author = book.getAuthor();
    }


    public CartItem(Book book, Integer count)//将指定数量的书添加进商品项
    {
        this.id = book.getId();
        this.name = book.getName();
        this.count = count;
        this.price = book.getPrice();
        this.totalPrice = MyUtils.mul(count, price);
        this.imagepath = book.getImagepath();
        this.author = book.getAuthor();
    }

    public CartItem(Integer id, String name, Integer count, Double price, Double totalPrice)
    {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public CartItem(Integer id, String name, Integer count, Double price, Double totalPrice, String imagepath, String author)
    {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.imagepath = imagepath;
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getImagepath()
    {
        return imagepath;
    }

    public void setImagepath(String imagepath)
    {
        this.imagepath = imagepath;
    }

    @Override
    public String toString()
    {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", imagepath='" + imagepath + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
