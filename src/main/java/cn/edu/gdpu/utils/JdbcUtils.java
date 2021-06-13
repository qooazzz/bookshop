package cn.edu.gdpu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtils
{
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String user = "root";
    static String password1 = "123";
    static String url = "jdbc:mysql://localhost:3306/book?serverTimezone=Asia/Shanghai";
    static ThreadLocal<Connection> threadLocal = new ThreadLocal();

    public static Connection getConnection()
    {
        Connection conn = threadLocal.get();
        if (conn == null)
        {
            try
            {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password1);
                conn.setAutoCommit(false);
                threadLocal.set(conn);
            } catch (SQLException | ClassNotFoundException throwables)
            {
                throwables.printStackTrace();
                throw new RuntimeException();
            }
        }
        return conn;
    }

    public static void commmitAndClose()
    {
        Connection conn = threadLocal.get();
        if (conn != null)
        {
            try
            {
                conn.commit();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
                throw new RuntimeException();
            } finally
            {
                try
                {
                    conn.close();
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                    throw new RuntimeException();
                }
            }
        }
        threadLocal.remove();
    }

    public static void rollbackAndClose()
    {
        Connection conn = threadLocal.get();
        if (conn != null)
        {
            try
            {
                conn.rollback();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
                throw new RuntimeException();
            } finally
            {
                try
                {
                    conn.close();
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                    throw new RuntimeException();
                }
            }
        }
        threadLocal.remove();
    }

    public static void closeStatement(PreparedStatement ps)
    {
        try
        {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            new RuntimeException();
        }
    }
}
