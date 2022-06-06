<%@ page import="Persistence.DAO.LessonDAO" %>
<%@ page import="Persistence.DTO.Lesson" %>
<%@ page import="java.util.List" %>
<%@ page import="Persistence.DAO.InstructorDAO" %>
<%@ page import="Persistence.DTO.InstructorDTO" %><%--
  Created by IntelliJ IDEA.
  User: KIMMINJONG
  Date: 2022-05-29
  Time: 오후 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%

    LessonDAO lessonDAO = new LessonDAO();
    List<Lesson> list = lessonDAO.selectAll();
    InstructorDAO instructorDAO = new InstructorDAO();

%>

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
                    <%for(int i = 0; i < list.size() ; i++){
                        Lesson lesson  = list.get(i);
                        InstructorDTO instructorDTO = instructorDAO.selectInstructorById(lesson.getInstructorId());
                    %>
                    <tr>
                        <th>l<%=lesson.getLessonName()%></th>
                        <th><%=lesson.getClassroom()%></th>
                        <th><%=instructorDTO.getUserName()%></th>
                        <th><%=lesson.getPrice()%></th>
                        <th><button onclick = "수강신청">신청</button></th>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
    </body>
</html>
