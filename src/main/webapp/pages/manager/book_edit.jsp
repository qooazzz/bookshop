<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/book/static/script/jquery-1.7.2.js"></script>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            font-family: "Microsoft Yahei";
            color: #666;
        }

        a {
            text-decoration: none;
        }

        body {
            background-color: rgba(12, 140, 72, 0.05)
        }

        #main {
            height: 710px;
            width: 1526px;
            margin: auto;
        }

        #main::before {
            content: '';
            display: table;
        }

        #header {
            height: 50px;
            width: 1400px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 10px;
        }

        #welcome {
            line-height: 50px;
            height: 50px;
            font-size: 23px;
        }

        #divback {
            float: right;
        }

        #divback:hover #back {
            border: solid 1px black;
        }

        #back {
            float: right;
            line-height: 50px;
            height: 50px;
            font-size: 23px;
            border: solid 1px transparent;
            text-decoration: none;
        }

        #backword {
            width: 130px;
            text-align: center;
            margin: auto;
        }

        #content {
            background-color: white;
            height: 380px;
            width: 1400px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 10px;
            border: solid 2px black;
            overflow: auto;
        }

        #content table {
            margin: auto;
            margin-top: 50px;
        }

        #content table td {
            width: 120px;
            height: 40px;
            text-align: center;
            border-bottom: 1px #e3e3e3 solid;
            padding: 10px;
        }

        td input {
            height: 30px;
            text-align: center;
        }


    </style>


</head>
<body>


<div id="main">
    <div id="header">
        <span id="welcome">${param.id==null?"添加图片":"编辑图片"}</span>
        <div id="divback">
            <a id="back" href="/book/pages/manager/book_manage.jsp">
                <div id="backword">返回</div>
            </a>
        </div>
    </div>
    <div id="content">
        <form method="post" action="/book/bookservlet">
<%--           js点击事件修改提交地址 --%>
            <input type="hidden" name="action" value="${param.id==null?"add":"update"}"/>
            <input type="hidden" name="id" value="${param.id}"/>
            <input type="hidden" name="pageNo" value="${param.pageNo}"/>
            <table>
                <tr>
                    <td>图书名称</td>
                    <td>作者</td>
                    <td>价格</td>
                    <td>销量</td>
                    <td>库存</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td><input name="bookname" type="text" value="${book.name}"/>
                        <input type="hidden" name="id" value="${book.id}"></td>
                    <td><input name="author" type="text" value="${book.author}"/></td>
                    <td><input name="price" type="text" value="${book.price}"/></td>
                    <td><input name="sales" type="text" value="${book.sales}"/></td>
                    <td><input name="stock" type="text" value="${book.stock}"/></td>
                    <td><input name="submitbutton" type="submit"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
