<%@ page import="Persistence.DAO.InstructorDAO" %>
<%@ page import="Persistence.DAO.DBConfig" %>
<%@ page import="Persistence.DAO.LessonDAO" %>
<%@ page import="Persistence.DTO.UserDTO" %>
<%@ page import="Persistence.DTO.InstructorDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Service.LessonManagementService" %>
<%@ page import="Persistence.DAO.SaleDAO" %><%--
  Created by IntelliJ IDEA.
  User: KIMMINJONG
  Date: 2022-06-05
  Time: 오후 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>enrollButtonClick</title>
</head>
<body>
    <%
        String lesson_name = request.getParameter("lesson_name");
        String classroom = request.getParameter("classroom");
        int price = Integer.parseInt(request.getParameter("price"));
        String instructor = request.getParameter("instructor");

        DBConfig dbConfig  = new DBConfig();
        SaleDAO saleDAO = new SaleDAO();
        LessonDAO lessonDAO = new LessonDAO();
        InstructorDAO instructorDAO = new InstructorDAO(dbConfig.getConnection());

        LessonManagementService lessonManagementService = new LessonManagementService(saleDAO,lessonDAO);
        List<InstructorDTO> list = instructorDAO.selectInstructor();

        for(InstructorDTO dto : list)
        {
            if(dto.getUserName().equals(instructor))
            {
                HashMap<String,Object> map = new HashMap<>();
                map.put("lessonName",lesson_name);
                map.put("classroom",classroom);
                map.put("price",price);
                map.put("instructorId",dto.getInstructorId());
                lessonManagementService.createLesson(map);
                break;
            }

        }

        response.sendRedirect("mainView.jsp");
    %>
    </body>
</html>
