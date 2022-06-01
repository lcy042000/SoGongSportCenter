<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="Persistence.DTO.InstructorDTO" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>

<%
    //List<Instructor> instructorList = selectAllInstructor();
    //List<InstructorDTO> instructorList = new ArrayList<>();

%>
<html>
<head>
    <title>강습 등록</title>
</head>

<style>
    .lesson_enroll_container
    {
        margin: 0 auto;
        text-align: center;
    }

    h1
    {
        text-align: center;
    }

    form
    {
        display: inline-block;
    }

    input
    {
        margin : 2px auto;
    }

</style>
<body>
    <h1> 강습 등록 </h1>
    <div class = "lesson_enroll_container">

        <div class = "lesson_enroll_form">
            <form action="#">
                <div><label for="lesson_name">강좌 이름</label><input type="text" id = "lesson_name" placeholder="강좌 이름 입력" required></div>
                <div><label for="classroom">강의실</label><input type="text" id = "classroom" placeholder="장소 입력" required></div>
                <div><label for="price">강습료</label><input type="text" id = "price" placeholder="가격 입력" required></div>
                <div><label>강사 선택</label>
                    <select id="select_instructor">
<%--                        <%  int i;--%>
<%--                            for( i = 0 ; i < instructorList.size();i++){ %>--%>
<%--                        <option value="<%=i%>"><% instructorList.get(i); %></option>--%>
<%--                        <% } %>--%>
                        <option value="archi">건축공학과</option>
                        <option value="mechanic">기계공학과</option>
                        <option value="indust">산업공학과</option>
                        <option value="elec">전기전자공학과</option>
                        <option value="computer">컴퓨터소프트웨어공학과</option>
                        <option value="chemical">화학공학과</option>
                    </select>
                </div>

                <div><input type="button" onclick="" value="등록">&nbsp<input type="button" onclick="" value="취소"> </div>



            </form>
        </div>
    </div>

</body>
</html>
