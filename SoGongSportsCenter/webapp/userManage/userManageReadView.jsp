<%--
  Created by IntelliJ IDEA.
  User: ATIV
  Date: 2022-05-25
  Time: 오전 1:06
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
            justify-content: center;
        }
        li{
            display: flex;
            list-style:none;
            background-color: gainsboro;
            padding: 20px;
            margin: 20px;
            border-radius: 15px;
        }
        a:link{
            color: black;
            text-decoration: none;
        }
        a:visited{
            color: black;
            text-decoration: none;
        }
        .contents_container{
            display: flex;
        }
        .sidebar{
            display: flex;
            flex-direction: column;
            padding: 20px;
            margin: 20px;
            border-radius: 15px;
        }
        .content{
            display: flex;
            flex-direction: column;
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
<div class="contents_container">
    <div class="sidebar">
        <li><a href="/userManage/enroll">회원 등록</a></li>
        <li><a href="/userManage/read">회원 조회</a></li>
    </div>
    <div class="content">
        <h2>사용자 조회</h2>
        <form method="get" action="/userManage/read">
            <select id="method" name="method">
                <option value="">조회 방식</option>
                <option value="all">모두</option>
                <option value="name">이름</option>
                <option value="type">타입</option>
            </select>
            <input type="text" name="data">
            <input type="submit" value="submit">
        </form>
    </div>
</div>
</body>
</html>
