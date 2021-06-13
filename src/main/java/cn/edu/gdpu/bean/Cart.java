package cn.edu.gdpu.bean;


import cn.edu.gdpu.utils.MyUtils;

import java.util.HashMap;
import java.util.Map;


public class Cart
{
    Integer totalCount = 0;//商品数量
    Double totalPrice = 0.0;//商品总价
    Map<Integer, CartItem> cartItems = new HashMap();

    public Cart()
    {
    }

    public Cart(Integer totalCount, Double totalPrice, Map<Integer, CartItem> cartItems)
    {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.cartItems = cartItems;
    }

    public Integer getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount)
    {
        this.totalCount = totalCount;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Map<Integer,CartItem> getCartItems()
    {
        return cartItems;
    }

    public void setCartItems(Map<Integer,CartItem> cartItems)
    {
        this.cartItems = cartItems;
    }

    @Override
    public String toString()
    {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", cartItems=" + cartItems +
                '}';
    }

    public void addItem(CartItem cartitem)//购物车添加新商品
    {
        CartItem item = cartItems.get(cartitem.getId());
        if (item != null)//购物车已存在该商品
        {
            item.setCount(item.getCount() + cartitem.getCount());//修改该商品数量
            item.setTotalPrice(MyUtils.mul(item.getPrice(), item.getCount()));//修改该商品总价
        }
        else
        {
            cartItems.put(cartitem.getId(), cartitem);
        }
        totalCount = totalCount + cartitem.getCount();
        totalPrice = MyUtils.add(totalPrice, cartitem.getTotalPrice());
    }

    public void deleteItem(Integer id)
    {
        CartItem item = cartItems.get(id);
        cartItems.remove(id);
        totalCount -= item.getCount();
        totalPrice = MyUtils.sub(totalPrice, item.getTotalPrice());
    }

    public void clear()
    {
        cartItems.clear();
        totalCount = 0;
        totalPrice = 0.0;
    }

    public void updateItemCount(CartItem cartitem)
    {
        CartItem item = cartItems.get(cartitem.getId());//获取旧的商品信息
        cartItems.put(cartitem.getId(), cartitem);
        totalCount = totalCount - item.getCount() + cartitem.getCount();//更新数量和总价
        totalPrice = MyUtils.add(MyUtils.sub(totalPrice, item.getTotalPrice()), cartitem.getTotalPrice());
    }
}
