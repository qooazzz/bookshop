<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>在线书城注册页面</title>
    <link rel="stylesheet" type="text/css" href="/book/static/css/2.css"/>
    <script type="text/javascript" src="/book/static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">

        $(function () {

            $("#username").blur(function () {//失去焦点事件 用户名:必须由字母，数字下划线组成，并且长度为1到12位
                var username = $("#username").val();
                var usernamePatt = /^\w{1,12}$/;
                if (!usernamePatt.test(username))
                    $("#usernametip").text("用户名格式不对!");
                else
                    $("#usernametip").text("");

                if (username != "") {
                    $.ajax({
                        url: "/book/userservlet/ajaxExistUserName",
                        data: "username=" + username,
                        type: "POST",
                        success: function(data) {
                            alert(data);
                            alert(typeof(data));

                            $("#tip3").text(data);

                        }
                    });
                } else
                    $("#tip3").text("");
            });

            $("#password").blur(function () {//失去焦点事件 密码:必须由字母，数字下划线组成，并且长度为5到12位
                var password = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password))
                    $("#passwordtip").text("密码格式不对!");
                else
                    $("#passwordtip").text("");
            });

            $("#password1").blur(function () {
                var password = $("#password").val();
                var password1 = $("#password1").val();
                if (password != password1)
                    $("#password1tip").text("两次密码不一致！");
                else
                    $("#password1tip").text("");

            });

            $("#email").blur(function () {
                var email = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;

                if (!emailPatt.test(email))
                    $("#emailtip").text("邮箱格式不合法！");
                else
                    $("#emailtip").text("");
            });

            $("#code").blur(function () {
                var code = $("#code").val();
                code = $.trim(code);
                if (code == null || code === "") {
                    $("#codetip").text("验证码不能为空！");
                    return false;
                } else
                    $("#codetip").text("");
            });

            $("#submitbutton").click(function () {

                if ($("#tip3").text().length > 0) {
                    return false;
                }

                var username = $("#username").val();
                var usernamePatt = /^\w{1,12}$/;
                if (!usernamePatt.test(username)) {
                    $("#usernametip").text("用户名格式不对!");
                    return false;
                }


                var password = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password)) {
                    $("#passwordtip").text("密码格式不对!");
                    return false;
                }

                var password1 = $("#password1").val();
                if (password !== password1) {
                    $("#password1tip").text("两次密码不一致！");
                    return false;
                }

                var email = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(email)) {
                    $("#emailtip").text("邮箱格式不合法！");
                    return false;
                }

                var code = $("#code").val();
                code = $.trim(code);
                if (code == null || code === "") {
                    $("#codetip").text("验证码不能为空！");
                    return false;
                }
            });

            //验证码的点击刷新
            $("#codeimg").click(function () {
                $(this).attr("src", "/book/kaptcha?d=" + new Date());
            });
        })
        ;

    </script>
</head>
<body>
<div id="regist_body">

    <div id="img"></div>
    <div id="regist_content">
        <div id="content">
            <div id="regist_title">注册</div>
            <div id="form" class="myform">
                <form action="/book/userservlet/regist" method="post">
                    <label for="username">用户名称：</label> <input id="username" name="username" type="text"
                                                               value="${username}"/>
                    <span id="tip3" style="color: red"></span><br/>
                    <span id="usernametip" class="tip"></span><br/>
                    <label for="password">用户密码：</label> <input id="password" name="password" type="text"/><br/>
                    <span id="passwordtip" class="tip"></span><br/>
                    <label for="password1">确认密码：</label> <input id="password1" name="password1" type="text"/><br/>
                    <span id="password1tip" class="tip"></span><br/>
                    <label for="email">电子邮件：</label> <input id="email" name="email" type="text" value="${email}"/><br/>
                    <span id="emailtip" class="tip"></span><br/>
                    <label id="labelcode" for="code">验证码：</label> <input id="code" name="code" type="text"
                                                                         value="${code}"/>
<%--                    <img src="/book/kaptcha" id="codeimg"/>--%>
                    <span id="codetip" class="tip"></span><br/>
                    <input name="action" type="hidden" value="regist"/>
                    <input id="submitbutton" type="submit" value="注册"/></br>
                    <span id="tip2">${msg}</span>
                </form>
            </div>
        </div>
    </div>

</div>
<%
    session.setAttribute("msg", "");
    session.setAttribute("username", "");
    session.setAttribute("email", "");
    session.setAttribute("code", "");
%>
</body>
</html>