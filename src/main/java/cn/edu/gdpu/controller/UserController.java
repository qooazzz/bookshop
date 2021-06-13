package cn.edu.gdpu.controller;

import cn.edu.gdpu.bean.User;
import cn.edu.gdpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@RequestMapping("/userservlet")
@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        User user = new User(null, username, password, null);
        HttpSession session = request.getSession();
        boolean flag = userService.login(user);
        if (flag)
        {
            Integer id = userService.getUserIdByName(user.getName());
            user.setId(id);
            session.setAttribute("user", user);
            response.sendRedirect("/book/index.jsp");
        }
        else
        {
            session.setAttribute("username", user.getName());
            session.setAttribute("msg", "账户或密码错误!");
            response.sendRedirect("/book/pages/login/login.jsp");
        }
    }

//    @RequestMapping("/regist")
//    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String password1 = request.getParameter("password1");
//        String email = request.getParameter("email");
//        String code = request.getParameter("code");
//
//        HttpSession session = request.getSession();
//        session.setAttribute("username", username);
//        session.setAttribute("email", email);
//        session.setAttribute("code", code);
//
//        String googleCode = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
//
//        session.removeAttribute(KAPTCHA_SESSION_KEY);
//        if (!googleCode.equalsIgnoreCase(code))//判断验证码是否正确
//        {
//            session.setAttribute("msg", "验证码输入错误!");
//            System.out.println("验证码输入错误!");
//            response.sendRedirect("/book/pages/regist/regist.jsp");
//        }
//        else
//        {
//            boolean flag = userService.isExistsUsername(username);//判断用户名是否存在
//            if (flag)
//            {
//                session.setAttribute("msg", "此用户已存在!");
//                System.out.println("此用户已存在");
//                response.sendRedirect("/book/pages/regist/regist.jsp");
//            }
//            else
//            {
//                flag = userService.regist(new User(null, username, password, email));
//                if (flag)
//                {
//                    response.sendRedirect("/book/pages/login/login.jsp?flag=1");
//                }
//                else
//                {
//                    session.setAttribute("msg", "注册失败!");
//                    System.out.println("注册失败!");
//                    response.sendRedirect("/book/pages/regist/regist.jsp");
//                }
//            }
//        }
//    }


//    @RequestMapping("/ajaxExistUserName"),produces = "application/json;charset=utf-8"
    @RequestMapping("/ajaxExistUserName")
    @ResponseBody
    protected String ajaxExistUserName(String username, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        System.out.println(username);
        return userService.isExistsUsername(username)?"用户已存在":"";
    }

    @RequestMapping("/logout")
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect(request.getHeader("Referer"));
    }
}
