<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>在线书城</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            font-family: "Microsoft Yahei";
            color: #666;
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

        /*头部*/
        #divlogout, #divorder, #divcart, #divmanage {
            float: right;

        }

        #divlogout:hover #logout, #divorder:hover #order, #divcart:hover #cart, #divmanage:hover #manage {
            border: solid 1px black;
        }

        #cart, #order, #logout, #manage {
            float: right;
            line-height: 50px;
            height: 50px;
            font-size: 23px;
            border: solid 1px transparent;
            text-decoration: none;
        }

        #manage {
            width: 150px;
        }

        #manageword {
            width: 130px;
            text-align: center;
            margin: auto;
        }

        #cart {
            width: 125px;
        }

        #cart::before {
            content: '';
            display: table;
        }

        #cartimage {
            width: 50px;
            height: 50px;
            background-image: url("/book/static/img/4.png");
            background-size: auto 100%;
            float: left;
        }

        #order {
            width: 145px;
        }

        #orderimage {
            width: 40px;
            height: 40px;
            margin-top: 7px;
            background-image: url("/book/static/img/5.png");
            background-size: auto 100%;
            float: left;
        }

        #orderword {
            width: 120px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }


        #logout {
            width: 100px;
        }

        #logoutimage {
            width: 28px;
            height: 28px;
            margin-top: 12px;
            background-image: url("/book/static/img/6.png");
            background-size: auto 100%;
            float: left;
            margin-left: 10px;
        }

        #logoutword {
            width: 55px;
            text-align: center;
            float: left;
        }

        #content {
            background-color: white;
            height: 540px;
            width: 1400px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 10px;
            border: solid 2px black;
        }

    </style>
</head>
<body>
<div id="main">
    <div id="header">
        <span></span>
        <span id="welcome">您好，欢迎来到在线书城</span>
        <div id="divlogout">
            <a id="logout" href="">
                <div id="logoutimage"></div>
                <div id="logoutword">注销</div>
            </a>
        </div>
        <div id="divorder">
            <a id="order" href="">
                <div id="orderimage"></div>
                <div id="orderword">我的订单</div>
            </a>
        </div>
        <div id="divcart">
            <a id="cart" href="">
                <div id="cartimage"></div>
                购物车
            </a>
        </div>
        <div id="divmanage">
            <a id="manage" href="/book/pages/manager/manage.html">
                <div id="manageword">后台管理</div>
            </a>
        </div>
    </div>
    <div id="content">

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