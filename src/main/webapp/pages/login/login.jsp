<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>在线书城</title>
    <link rel="stylesheet" type="text/css" href="/book/static/css/1.css"/>
    <script type="text/javascript">
        var a =${param.flag};
        if (a == 1)
            alert("注册成功！");
    </script>

</head>
<body>
<div id="login_body">
    <div id="img"></div>
    <div id="login_content">

        <div id="content">
            <div id="login_title">
                <span>用户登录</span>
                <a href="/book/pages/regist/regist.jsp">立刻注册</a>
            </div>

            <div id="tip1">请输入用户名和密码</div>
            <div id="form" class="myform">
                <form method="post" action="/book/userservlet/login">
                    <label for="username"> 用户名称:</label><input id="username" name="username" type="text"
                                                               value="${username}"/><br/>
                    <label for="password"> 用户密码:</label><input id="password" name="password" type="password"/><br/>
                    <input id="submitbutton" type="submit" value="登录"/><br/>
                    <span id="tip2">${msg}</span>
                </form>
            </div>
        </div>
    </div>

</div>
<%
    session.setAttribute("msg", "");
    session.setAttribute("username", "");
%>
</body>
</html>