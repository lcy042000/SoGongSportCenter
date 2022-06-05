<%@ page import="Persistence.DAO.LessonDAO" %>
<%@ page import="Persistence.DAO.UserDAO" %>
<%@ page import="Persistence.DAO.DBConfig" %>
<%@ page import="Persistence.DTO.UserDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="Persistence.DTO.Lesson" %>
<%@ page import="Persistence.DAO.SaleDAO" %>
<%@ page import="Persistence.DTO.SaleDTO" %>
<%@ page import="java.util.Date" %>
<%@ page import="Service.LessonManagementService" %><%--
  Created by IntelliJ IDEA.
  User: KIMMINJONG
  Date: 2022-06-05
  Time: 오후 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registrationLesson</title>
</head>
<body>
<%
    String lesson_name = request.getParameter("lesson_name");
    String classroom = request.getParameter("classroom");
    String user_name = request.getParameter("user_name");
    String price = request.getParameter("price");

    DBConfig dbConfig = new DBConfig();

    LessonDAO lessonDAO = new LessonDAO();
    UserDAO userDAO = new UserDAO(dbConfig.getConnection());
    SaleDAO saleDAO = new SaleDAO();


    Lesson lesson = lessonDAO.selectLessonWithName(lesson_name);
    List<UserDTO> userDTOs = userDAO.selectUserByName(user_name);
    UserDTO userDTO = userDTOs.get(0);

    LessonManagementService lessonManagementService = new LessonManagementService(userDAO,saleDAO,lessonDAO);
    lessonManagementService.lectureRegistration(userDTO.getUserId(),lesson.getId());

    response.sendRedirect("mainView.jsp");

%>
</body>
</html>
