<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理</title>
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
            /*border-collapse: collapse;*/
        }

        #content table td {
            width: 120px;
            text-align: center;
            border-bottom: 1px #e3e3e3 solid;
            padding: 10px;
        }

        #addtip {
            float: right;
            margin-right: 100px;
            font-size: 20px;
        }

        /*分页*/
        #paging {
            margin: auto;
            margin-top: 15px;
            display: table;
            font-size: 17px;
        }

        #paging a {
            margin-left: 10px;
            border: solid 2px rgb(221, 221, 221);
        }

        #paging a:hover {
            background-color: rgb(0, 161, 214);
            color: white;
        }

        #paging span {
            margin-left: 10px
        }

        #pagingform {
            display: inline
        }

        #paginginput {
            width: 30px;
            text-align: center;
        }
    </style>


</head>
<body>


<div id="main">

    <div id="header">
        <div id="divback">
            <a id="back" href="/book/pages/manager/manage.jsp">
                <div id="backword">返回</div>
            </a>
        </div>
    </div>

    <div id="content">
        <div id="addtip"><a href="/book/pages/manager/book_edit.jsp">添加图书</a></div>
        <table>
            <tr>
                <td>图书名称</td>
                <td>作者</td>
                <td>价格</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td> ${book.name} </td>
                    <td> ${book.author} </td>
                    <td> ${book.price} </td>
                    <td>${book.sales} </td>
                    <td> ${book.stock} </td>
                    <td><a href="/book/bookservlet/getBookById?id=${book.id}&pageNo=${page.pageNo}">编辑</a></td>
                    <td><a href="/book/bookservlet/delete?id=${book.id}&pageNo=${page.pageNo}">删除</a></td>
                </tr>
            </c:forEach>
        </table>

        <div id="paging">
            <c:if test="${page.pageNo!=1}">
                <a href="/book/bookservlet/page?pageNo=1">首页</a>
                <a href="/book/bookservlet/page?pageNo=${page.pageNo-1}">上一页</a>
            </c:if>
            <span> 当前是第${page.pageNo}页 </span>
            <c:if test="${page.pageNo!=page.pageTotal}">
                <a href="/book/bookservlet/page?pageNo=${page.pageNo+1}">下一页</a>
                <a href="/book/bookservlet/page?pageNo=${page.pageTotal}">末页</a>
            </c:if>
            <span>共${page.pageTotal}页</span>
            <span>跳转到</span>
            <form id="pagingform" method="post" action="/book/bookservlet/page">
                <input id="paginginput" name="pageNo" type="text"/>页 <input type="submit" value="确定"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
