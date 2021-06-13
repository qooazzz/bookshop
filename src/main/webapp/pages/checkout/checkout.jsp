<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>在线书城</title>
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
            /*border-collapse: collapse;*/
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
            $("#back").click(function () {
                location.href="/book/index.jsp";
                return false;
            });

            $("#paybutton").click(function () {
                location.href="/book/orderservlet/payOrder?orderId=" + ${order.id};
            });
        });

    </script>
</head>
<body>

<div id="main">
    <div id="header">
        <span id="welcome">订单信息</span>
        <div id="divback">
            <a id="back" href="">
                <div id="backword">返回首页</div>
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
            <tr>
                <td>${order.id}</td>
                <td>${order.createTime}</td>
                <td>${order.price}</td>
                <td>
                    <c:choose>
                        <c:when test="${order.status==0}">未支付</c:when>
                        <c:when test="${order.status==1}">已支付，等待商家发货</c:when>
                        <c:when test="${order.status==2}">商家已发货，等待签收</c:when>
                        <c:when test="${order.status==3}">用户已签收</c:when>
                    </c:choose>

                </td>
                <td><c:if test="${order.status==0}">
                    <input id="paybutton" style="height: 25px; width: 50px;font-size: 15px" type="button" value="支付">
                </c:if>
                </td>
            </tr>
        </table>

    </div>
</div>
</body>
</html>