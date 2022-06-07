<%@ page import="java.io.PrintWriter" %>
<%@ page import="Service.AnnouncementService" %>
<%@ page import="Persistence.DTO.AnnouncementDTO" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="Persistence.DTO.AttachedFileDTO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="jdk.jshell.spi.ExecutionControl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="announcement" class="Persistence.DTO.AnnouncementDTO" scope="page"></jsp:useBean>
<jsp:useBean id="attachedFile" class="Persistence.DTO.AttachedFileDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="announcement" property="announcementTitle"></jsp:setProperty>
<jsp:setProperty name="announcement" property="announcementContent"></jsp:setProperty>
<jsp:setProperty name="attachedFile" property="attachedFile"></jsp:setProperty>
<html>
<head>
    <title>소공 체육 센터</title>
</head>
<body>
    <%
        int announcementId = -1;

        if(session.getAttribute("announcementId") != null){
            announcementId = (int)session.getAttribute("announcementId");
        }

        if(announcement.getAnnouncementTitle() == null) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('제목을 입력하세요.')");
            script.println("history.back()");
            script.println("</script>");
        }else {
            AnnouncementService service = new AnnouncementService();

            int isAttachedFile = 0;

            if(attachedFile.getAttachedFile() != null){
                isAttachedFile = 1;
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('파일 들어옴')");
                script.println("history.back()");
                script.println("</script>");
            }

            AnnouncementDTO announcementDTO = new AnnouncementDTO(announcement.getAnnouncementTitle(), announcement.getAnnouncementContent(), "관리자",
                    java.sql.Date.valueOf(LocalDate.now()), isAttachedFile, 0);

            AttachedFileDTO attachedFileDTO = new AttachedFileDTO(-1, -1, attachedFile.getAttachedFile());

            HashMap<String, Object> resultMap = service.createAnnouncement(announcementDTO, attachedFileDTO);

            int insertId = (int) resultMap.get("insertID");
            boolean result = (boolean) resultMap.get("result");

            if(result){
                session.setAttribute("announcementId", insertId);
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("location.href = 'announcementRead.jsp'");
                script.println("</script>");
            }else{
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('글쓰기에 실패했습니다.')");
                script.println("history.back()");
                script.println("</script>");
            }
        }
    %>
</body>
</html>
