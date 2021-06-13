<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的购物车</title>
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
        }

        #content table td {
            width: 120px;
            text-align: center;
            border-bottom: 1px #e3e3e3 solid;
            padding: 10px;
        }


        .deleteItem {
            color: blue;
        }

        /*图片*/
        #divbook {
            width: 270px;
            height: 270px;
            margin-top: 60px;
            margin-left: 60px;
            float: left;
        }

        #divimage {
            width: 270px;
            height: 180px;
        }

        img[src=""], img:not([src]) {
            opacity: 0;
        }


        #tip {
            color: blue;
        }

        #fooder {
            display: table;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5px;
        }

        #fooder span {
            margin: 10px;
            font-size: 20px;
        }

        #fooder a {
            color: blue;
        }

    </style>


    <script type="text/javascript">
        $(function () {
            $("#clearcart").click(function () {
                return confirm("你确定要清空购物车吗？");
            });


            $(".deleteItem").click(function () {
                var bookname = $(this).parent().parent().find("td:first").find("a").text();
                return confirm("确定从购物车中删除《" + bookname + "》吗？");
            });

            $(".itemCount").change(function () {
                var flag = confirm("是否确定修改该商品数量");
                var bookId = $(this).attr("bookId");
                if (flag == true) {
                    location.href = "/book/cartservlet/updateItem?id=" + bookId + "&count=" + $(this).val();
                    return true;
                }
                return false;
            });

            $(".showimage").mouseover(function () {
                var path = $(this).attr("imagePath");
                $("#tipimage").attr("src", "/book/" + path);
                $(this).css("backgroundColor", "rgba(186, 236, 229, 0.35)");

                var author = $(this).attr("bookAuthor");
                $("#tipauthor").text("作者:" + author);
            });
            $(".showimage").mouseout(function () {
                $("#tipimage").removeAttr("src");
                $(this).css("backgroundColor", "white");
                $("#tipauthor").text("");
            });

            $("#back").click(function () {
                location.href = "/book/index.jsp";
                return false;
            });

        });
    </script>


</head>
<body>

<div id="main">
    <div id="header">
        <div id="divback">
            <a id="back" href="">
                <div id="backword">返回</div>
            </a>
        </div>
    </div>
    <div id="content">
        <div id="divbook">
            <div id="divimage">
                <img id="tipimage" height="180px"/>
            </div>
            <div style="font-size: 20px;" id="tipauthor">
            </div>
        </div>

        <table>
            <tr>
                <td>商品名称</td>
                <td>商品数量</td>
                <td>商品单价</td>
                <td>商品总价</td>
                <td colspan="2">操作</td>
            </tr>
            <c:if test="${not empty cart.cartItems}">
                <c:forEach items="${cart.cartItems}" var="item">
                    <tr class="showimage" imagePath="${item.value.imagepath}" bookAuthor="${item.value.author}">
                        <td><a href="">${item.value.name}</a>
                        </td>
                        <td><input class="itemCount" bookId="${item.value.id}" style="width: 80px;text-align: center"
                                   value="${item.value.count}"/></td>
                        <td> ${item.value.price} </td>
                        <td>${item.value.totalPrice} </td>
                        <td><a class="deleteItem" href="/book/cartservlet/action=delete?id=${item.key}">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>

            <c:if test="${empty cart.cartItems}">
                <tr>
                    <td colspan="4">购物车为空</td>
                    <td><a id="tip" href="/book/index.jsp">返回首页</a></td>
                </tr>
            </c:if>
        </table>

    </div>
    <c:if test="${not empty cart.cartItems}">
        <div id="fooder">
            <span>购物车共有${cart.totalCount}件商品</span>
            <span>总金额${cart.totalPrice}元</span>
            <span><a href="/book/orderservlet/createOrder">结账</a></span>
            <span><a id="clearcart" href="/book/cartservlet/clear">清空购物车</a></span>
            <span><a href="/book/index.jsp">返回首页</a></span>
        </div>
    </c:if>
</div>


</body>


</html>

