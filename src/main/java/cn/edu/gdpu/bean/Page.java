package cn.edu.gdpu.bean;

public class Page
{
    public static final Integer PAGE_SIZE = 4;
    private Integer pageNo;//页码
    private Integer pageTotal;//总页码
    private Integer pageSize = PAGE_SIZE;
    private String url;

    public Page()
    {
    }

    public Page(Integer pageNo, Integer pageTotal)
    {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize)
    {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, String url)
    {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Page(Integer pageNo)
    {
        this.pageNo = pageNo;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal()
    {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal)
    {
        this.pageTotal = pageTotal;
    }

    @Override
    public String toString()
    {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", url='" + url + '\'' +
                '}';
    }
}
