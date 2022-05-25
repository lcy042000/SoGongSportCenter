<%--
  Created by IntelliJ IDEA.
  User: ATIV
  Date: 2022-05-24
  Time: 오후 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SOGONG Sport Center</title>
    <style>
        h1{
            text-align: center;
        }
        .container{
            display: flex;
        }
        li{
            list-style:none;
            background-color: gainsboro;
        }
        a:link{
            color: black;
            text-decoration: none;
        }
        a:visited{
            color: black;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <p><h1><a href="/">소공체육센터관리</a></h1></p>
    <div class="container">
        <li>
            <a href="/userManage">사용자 관리</a>
        </li>
        <li>
            <a href="#">강사 관리</a>
        </li>
        <li>
            <a href="#">1 관리</a>
        </li>
        <li>
            <a href="#">2 관리</a>
        </li>
        <li>
            <a href="#">3 관리</a>
        </li>
    </div>
</body>
</html>
