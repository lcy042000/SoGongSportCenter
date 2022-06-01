<%--
  Created by IntelliJ IDEA.
  User: KIMMINJONG
  Date: 2022-05-29
  Time: 오후 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>수강 신청</title>
    </head>

    <style>
        .registration_container
        {
            margin: 0 auto;
            text-align: center;
        }
        h1
        {
            text-align: center;
        }

        table
        {
            width: 100%;
            border: 3px solid black;
            border-collapse: collapse;
        }

        th, td
        {
            border: 1px solid black;
        }
    </style>

    <body>
    <h1>수강 신청</h1>
        <div class = "registration_container">

            <form action="">
                <span><label for="search_lesson">검색</label><input type="search" id = "search_lesson">
                    <select id="options">
                        <option value="name" selected>이름으로 검색</option>
                        <option value="id">아이디로 검색</option>
                    </select>

                    <input type="button" onclick="" value="조회">
                    <input type="button" onclick="" value="취소">
                </span>
            </form>

            <div style="width:100%; height:200px; overflow:auto">
                <table>
                    <tr>
                        <th>강습 이름</th>
                        <th>강습 장소</th>
                        <th>강사명</th>
                        <th>가격</th>
                        <th>신청</th>
                    </tr>
                    <%for(int i = 0; i < 10 ; i++){%>
                    <tr>
                        <th>강습 이름<%=i%></th>
                        <th>강습 장소<%=i%></th>
                        <th>강사명<%=i%></th>
                        <th>가격<%=i%></th>
                        <th>신청<%=i%></th>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
    </body>
</html>
