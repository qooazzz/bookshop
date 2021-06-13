package cn.edu.gdpu.bean;

public class User
{
    Integer id;
    String name;
    String password;
    String email;

    public User()
    {
    }

    public User(Integer id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(Integer id, String name, String password, String email)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
