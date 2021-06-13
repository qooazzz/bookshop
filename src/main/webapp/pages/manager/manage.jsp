<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>在线书城</title>
    <script type="text/javascript" src="/book/static/script/jquery-1.7.2.js"></script>
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


        #divbookmanage {
            float: right;
        }

        #divbookmanage:hover #bookmanage {
            border: solid 1px black;
        }

        #bookmanage {
            float: right;
            line-height: 50px;
            height: 50px;
            font-size: 23px;
            border: solid 1px transparent;
            text-decoration: none;
        }

        #bookmanage {
            width: 150px;
        }

        #bookmanageword {
            width: 130px;
            text-align: center;
            margin: auto;
        }

        #content {
            background-color: white;
            height: 580px;
            width: 1400px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 10px;
            border: solid 1px black;
        }

        #content table {
            margin: auto;
            margin-top: 50px;
        }

        #content table td {
            width: 210px;
            text-align: center;
            border-bottom: 1px #e3e3e3 solid;
            padding: 10px;
        }

    </style>

    <script type="text/javascript">
        $(function () {
            $(".sendbutton").click(function () {
                var orderId = $(this).parent().parent().find("td:first").text();
                location.href = "/book/orderservlet/sendOrder?orderId=" +orderId;
            });
        });
    </script>

</head>
<body>
<div id="main">
    <div id="header">
        <span id="welcome">后台管理</span>
        <div id="divback">
            <a id="back" href="/book/index.jsp">
                <div id="backword">返回</div>
            </a>
        </div>
        <div id="divbookmanage">
            <a id="bookmanage" href="/book/bookservlet/page">
                <div id="bookmanageword">
                    图书管理
                </div>
            </a>
        </div>
    </div>

    <div id="content">
        <table>
            <tr>
                <td>订单号</td>
                <td>下单时间</td>
                <td>金额</td>
                <td>状态</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.createTime}</td>
                    <td>${order.price}</td>
                    <td>
                        <c:choose>
                            <c:when test="${order.status==0}">未支付</c:when>
                            <c:when test="${order.status==1}">用户已支付，等待商家发货</c:when>
                            <c:when test="${order.status==2}">商家已发货，等待签收</c:when>
                            <c:when test="${order.status==3}">用户已签收</c:when>
                        </c:choose>

                    </td>
                    <td>
                        <c:if test="${order.status==1}">
                            <input class="sendbutton" style="height: 25px; width: 50px;font-size: 15px" type="button"
                                   value="发货">
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>