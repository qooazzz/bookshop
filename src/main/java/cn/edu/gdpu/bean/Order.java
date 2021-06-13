package cn.edu.gdpu.bean;

public class Order
{
    String id;
    String createTime;
    String payTime;
    Double price;
    Integer userId;
    Integer status;

    public Order()
    {
    }

    public Order(String id, String createTime, String payTime, Double price, Integer userId, Integer status)
    {
        this.id = id;
        this.createTime = createTime;
        this.payTime = payTime;
        this.price = price;
        this.userId = userId;
        this.status = status;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getPayTime()
    {
        return payTime;
    }

    public void setPayTime(String payTime)
    {
        this.payTime = payTime;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", payTime='" + payTime + '\'' +
                ", price=" + price +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}
