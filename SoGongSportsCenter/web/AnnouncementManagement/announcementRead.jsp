<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Persistence.DTO.AnnouncementDTO" %>
<%@ page import="Persistence.DTO.AttachedFileDTO" %>
<%@ page import="Service.AnnouncementService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <head>
        <title>소공 체육 센터</title>
        <meta name="viewport" content="width=device-width", initial-scale="1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/announcement.css?ver=1">
    </head>
</head>
<body>
    <%
        int announcementId = -1;

        if(session.getAttribute("announcementId") != null){
            announcementId = (int)session.getAttribute("announcementId");
        }

        if(request.getParameter("announcementId") != null){
            announcementId = Integer.parseInt(request.getParameter("announcementId"));
        }

        if(announcementId < 1){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('유효하지 않은 글입니다.')");
            script.println("location.href = 'announcementList.jsp'");
            script.println("</script>");
        }

        HashMap<String, Object> map = new AnnouncementService().readAnnouncement(announcementId);
        AnnouncementDTO announcementDTO = (AnnouncementDTO) map.get("AnnouncementDTO");
        List<AttachedFileDTO> fileDTOList = (List<AttachedFileDTO>) map.get("AttachedFileDTO");
    %>
    <div class="header">
        <div class="logo"><h1>소공 체육 센터</h1></div>
    </div>

    <div class="nav-bar">
        <ul>
            <li><a href="/main.jsp">Home</a></li>
            <li class="dropdown">
                <a href="#" class="dropbtn">회원 관리</a>
                <div class="dropdown-content">
                    <a href="#">회원 등록</a>
                    <a href="#">회원 조회</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">강사 관리</a>
                <div class="dropdown-content">
                    <a href="#">강사 등록</a>
                    <a href="#">강사 조회</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">강습 관리</a>
                <div class="dropdown-content">
                    <a href="#">강습 등록</a>
                    <a href="#">수강 신청</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">공지사항</a>
                <div class="dropdown-content">
                    <a href="announcementCreate.jsp">공지 등록</a>
                    <a href="announcementList.jsp">공지 조회</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">사물함 관리</a>
                <div class="dropdown-content">
                    <a href="#">사물함 생성</a>
                    <a href="#">사물함 신청</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">매출 조회</a>
                <div class="dropdown-content">
                    <a href="#">기간별 매출 조회</a>
                    <a href="#">강습별 매출 조회</a>
                </div>
            </li>
        </ul>
    </div>

    <div class="container">
        <div class="row">
            <table class="table" style="text-align: center; border: 1px solid #dddddd">
                <thead>
                    <tr>
                        <th colspan="3" style="background-color: #eeeeee; text-align: center;">공지사항</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td style="width: 20%">제목</td>
                        <td colspan="3"><%=announcementDTO.getAnnouncementTitle().replaceAll(" ", "&nbsp")
                                .replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll("\n", "<br>")%></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td colspan="1"><%=announcementDTO.getAnnouncementWriterName()%></td>
                        <td>작성일자</td>
                        <td colspan="2"><%=announcementDTO.getWriteDate()%></td>
                    </tr>
                    <tr>
                        <td>조회수</td>
                        <td colspan="3"><%=announcementDTO.getHits()%></td>
                    </tr>
                    <tr>
                        <td>첨부파일</td>
                    <%
                        if(fileDTOList != null){
                            for(int i = 0; i < fileDTOList.size(); i++){
                    %>
                            <td colspan="3"><%=fileDTOList.get(i).attachedFile%></td>
                    <%
                            }
                        }
                    %>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td colspan="2" style="min-height: 200px; text-align: left;"><%=announcementDTO.getAnnouncementContent().replaceAll(" ", "&nbsp")
                                .replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll("\n", "<br>")%></td>
                    </tr>
                </tbody>
            </table>
            <a href="announcementList.jsp" class="writeBtn">목록</a>
        </div>
    </div>
</body>
</html>
