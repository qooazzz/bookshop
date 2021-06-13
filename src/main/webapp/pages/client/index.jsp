<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理</title>
    <script type="text/javascript" src="/book/static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".cartbutton").click(function () {
                var bookId = $(this).attr("bookId");
                var bookname = $(this).parent().parent().parent().find("div:eq(1)").find("span:eq(1)").text();
                var flag = confirm("是否将《" + bookname + "》加入购物车");
                if (flag == true) {
                    location.href = "/book/cartservlet/add?id=" + bookId;
                    return true;
                }
                return false;
            });
        });
    </script>

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
            position: relative;
        }

        /*头部*/
        #nametip {
            font-size: 25px;
            color: #ee305a
        }

        #welcome {
            line-height: 50px;
            height: 50px;
            font-size: 23px;
        }


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

        #search {
            top: 12px;
            left: 495px;
            height: 35px;
            width: 200px;
            position: absolute;
        }

        #searchimage {
            background-image: url("/book/static/img/3.png");
            background-size: auto 100%;
            background-color: #666666;
            width: 35px;
            height: 35px;
            color: black;
            top: 12px;
            left: 694px;
            position: absolute;
        }


        #content {
            background-color: white;
            height: 620px;
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

        /*分页*/
        #paging {
            margin: auto;
            margin-top: 15px;
            display: table;
            font-size: 17px;
            clear: left;
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


        /*展示部分*/
        #booklist {
            width: 870px;
            margin: auto;
        }

        #booklist::after {
            content: '';
            clear: both;
            display: table;
        }

        .divbook {
            width: 270px;
            height: 270px;
            margin: 10px;
            float: left;
        }

        .divimage {
            width: 270px;
            height: 153px;
        }

        .divbook div {
            font-size: 20px;
        }

        .divbutton {
            float: right;
        }

        .cartbutton {
            font-size: 15px;
        }

        #divlogin {
            float: right;
        }

        #divlogin:hover #login {
            border: solid 1px black;
        }

        #login {
            float: right;
            line-height: 50px;
            height: 50px;
            font-size: 23px;
            border: solid 1px transparent;
            text-decoration: none;
        }

        #loginword {
            width: 130px;
            text-align: center;
            margin: auto;
        }
    </style>


    <script type="text/javascript">
        $(function () {
            $("#searchimage").click(function () {
                var key = $("#search").val();
                if (key.length > 0)
                    location.href = "/book/client/bookservlet/pageByName?key=" + key;
                else
                    location.href = "/book/index.jsp";
                return false;
            });
        });
    </script>
</head>
<body>

<div id="main">
    <div id="header">
        <span id="welcome"><span id="nametip">${user.name}</span> 您好，欢迎来到在线书城</span>

        <c:if test="${user!=null}">
            <div id="divlogout">
                <a id="logout" href="/book/userservlet/logout">
                    <div id="logoutimage"></div>
                    <div id="logoutword">注销</div>
                </a>
            </div>
        </c:if>

        <div id="divorder">
            <a id="order" href="/book/orderservlet/getMyOrders">
                <div id="orderimage"></div>
                <div id="orderword">我的订单</div>
            </a>
        </div>

        <div id="divcart">
            <a id="cart" href="/book/pages/cart/cart.jsp">
                <div id="cartimage"></div>
                购物车
            </a>
        </div>

        <div id="divmanage">
            <a id="manage" href="/book/orderservle/getOrders">
                <div id="manageword">后台管理</div>
            </a>
        </div>

        <c:if test="${user==null}">
            <div id="divlogin">
                <a id="login" href="/book/pages/login/login.jsp">
                    <div id="loginword">登录</div>
                </a>
            </div>
        </c:if>

        <input id="search">

        <div id="searchimage"><a id="a_search" href="" style="width: 35px;height:35px;display: block"></a></div>

    </div>

    <div id="content">

        <div id="booklist">
            <c:forEach items="${books}" var="book">
                <div class="divbook">
                    <div class="divimage">
                        <img src="/book/${book.imagepath}" height="153px"/>
                    </div>
                    <div>
                        <span>书名:</span><span>${book.name}</span>
                    </div>
                    <div>
                        作者:${book.author}
                    </div>
                    <div>
                        价格:${book.price}
                    </div>
                    <div>
                        销量:${book.sales}
                    </div>
                    <div>
                        库存:${book.stock}
                        <div class="divbutton">
                            <button class="cartbutton" bookId="${book.id}">加入购物车</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div id="paging">
            <c:if test="${page.pageNo!=1}">
                <a href="${page.url}&pageNo=1">首页</a>
                <a href="${page.url}&pageNo=${page.pageNo-1}">上一页</a>
            </c:if>
            <span> 当前是第${page.pageNo}页 </span>
            <c:if test="${page.pageNo!=page.pageTotal}">
                <a href="${page.url}&pageNo=${page.pageNo+1}">下一页</a>
                <a href="${page.url}&pageNo=${page.pageTotal}">末页</a>
            </c:if>
            <span>共${page.pageTotal}页</span>
            <span>跳转到</span>
            <form id="pagingform" method="post" action="${page.url}">
                <input id="paginginput" name="pageNo" type="text"/>页 <input type="submit" value="确定"/>
            </form>
        </div>
    </div>

</div>

</body>

</html>
