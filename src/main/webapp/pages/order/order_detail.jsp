<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script type="text/javascript" src="/book/static/script/jquery-1.7.2.js"></script>
    <title>在线书城</title>
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
            width: 210px;
            text-align: center;
            border-bottom: 1px #e3e3e3 solid;
            padding: 10px;
        }

    </style>

    <script type="text/javascript">
        $(function () {
            $("#back").click(function () {
                window.history.go(-1);
                return false;
            });

        });
    </script>
</head>
<body>
<div id="main">
    <div id="header">
        <span id="welcome">订单详情</span>
        <div id="divback">
            <a id="back" href="">
                <div id="backword">返回</div>
            </a>
        </div>
    </div>
    <div id="content">
        <table>
            <tr>
                <td>订单号</td>
                <td>下单时间</td>
                <td>总金额</td>
                <td>状态</td>
            </tr>

            <tr>
                <td>${orderdetail.id}</td>
                <td>${orderdetail.createTime}</td>
                <td>${orderdetail.price}</td>
                <td>
                    <c:choose>
                        <c:when test="${orderdetail.status==0}">未支付</c:when>
                        <c:when test="${orderdetail.status==1}">已支付，等待商家发货</c:when>
                        <c:when test="${orderdetail.status==2}">商家已发货，等待签收</c:when>
                        <c:when test="${orderdetail.status==3}">用户已签收</c:when>
                    </c:choose>
                </td>
            </tr>


        </table>

        <table>
            <tr>
                <td>商品名</td>
                <td>数量</td>
                <td>单价</td>
                <td>总价</td>
            </tr>

            <c:forEach items="${orderItems}" var="orderItem">
                <tr>
                    <td>${orderItem.name}</td>
                    <td>${orderItem.count}</td>
                    <td>${orderItem.price}</td>
                    <td>${orderItem.totalPrice}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>
