package cn.edu.gdpu.bean;

public class Book
{
    Integer id;
    String name;
    String author;
    Double price;
    Integer sales;
    Integer stock;
    String publisher;
    String category;
    private String imagepath = "static/img/book/default.jpg";

    public Book()
    {
    }

    public Book(Integer id, String name, String author, Double price, Integer sales, Integer stock, String publisher, String category)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.publisher = publisher;
        this.category = category;
    }

    public Book(Integer id, String name, String author, Double price, String publisher, String category, String imagepath)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.category = category;
        this.imagepath = imagepath;
    }

    public String getImagepath()
    {
        return imagepath;
    }

    public void setImagepath(String imagepath)
    {
        this.imagepath = imagepath;
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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void setStock(Integer stock)
    {
        this.stock = stock;
    }

    public Integer getSales()
    {
        return sales;
    }

    public void setSales(Integer sales)
    {
        this.sales = sales;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", imagepath='" + imagepath + '\'' +
                '}';
    }
}
