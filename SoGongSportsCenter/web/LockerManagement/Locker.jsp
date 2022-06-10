<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="Persistence.DTO.LockerDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="Service.LockerService" %>
<html>
    <head>
        <title>소공 체육 센터</title>
        <meta name="viewport" content="width=device-width", initial-scale="1">
        <link rel="short icon" href="#">
        <style>
            table, th, td {
                border: 1px solid #bcbcbc;
            }

            table {
                width: 100%;
                height: 200px;
            }
        </style>
    </head>
    <body>

        <div style="display: flex; flex-direction: column; justify-content: center; align-content: center">
            <div style="display: flex; justify-content: space-between; align-content: center">
                <div class="locker-form">
                    <label>사물함 등록</label>

                    <form action="${pageContext.request.contextPath}/locker" method="post" autocomplete="on">
                        <div class="form-example">
                            <label>사물함 번호: </label>
                            <input type="text" name="lockerNumber" required>
                        </div>
                        <div>
                            <label>사물함 위치: </label>
                            <input type="text" name="lockerLocation">
                        </div>
                        <div>
                            <label>금액: </label>
                            <input type="text" name="amount">
                        </div>
                        <div>
                            <input type="submit" value="submit">
                        </div>
                    </form>
                </div>

                <div class="locker-form">
                    <label>사물함 삭제</label>

                    <form action="${pageContext.request.contextPath}/locker/delete" method="post" autocomplete="on">
                        <div class="form-example">
                            <label>사물함 번호: </label>
                            <input type="text" name="lockerNumber" required>
                        </div>
                        <div>
                            <input type="submit" value="submit">
                        </div>
                    </form>
                </div>

                <div>
                    <label>사물함 수정</label>

                    <form name="profile" action="${pageContext.request.contextPath}/locker/update" method="post"
                          autocomplete="on">
                        <div>
                            <label>사물함 번호: </label>
                            <input type="text" name="lockerNumber">
                        </div>
                        <div>
                            <label>사물함 위치: </label>
                            <input type="text" name="lockerLocation">
                        </div>
                        <div>
                            <label>금액: </label>
                            <input type="text" name="amount">
                        </div>
                        <div>
                            <label>사용자 번호: </label>
                            <input type="text" name="userId">
                        </div>
                        <div>
                            <input type="submit" value="submit">
                        </div>
                    </form>
                </div>

                <div>
                    <label>사물함 배정</label>

                    <form name="profile" action="${pageContext.request.contextPath}/locker/assign" method="post"
                          autocomplete="on">
                        <div class="form-example">
                            <label>사물함 번호: </label>
                            <input type="text" name="lockerNumber">
                        </div>
                        <div>
                            <label>사용자 번호: </label>
                            <input type="text" name="userId">
                        </div>
                        <div>
                            <input type="submit" value="submit">
                        </div>
                    </form>
                </div>
            </div>
            <div style="display: flex; justify-content: center; width: 80%;">
                <table height="200">
                    <caption>사물함 현황</caption>
                    <thead>
                    <tr>
                        <th>위치</th>
                        <th>번호</th>
                        <th>금액</th>
                        <th>사용자</th>
                    </tr>
                    </thead>

                    <tbody>
                        <%
                            LockerService lockerService = new LockerService();
                            List<LockerDTO> dtos = lockerService.readAll();

                            if (dtos.size() != 0) {
                                for(int i = 0; i < dtos.size(); i++){
                        %>
                        <tr>
                            <td><%=dtos.get(i).getLockerNumber()%></td>
                            <td><%=dtos.get(i).getLockerLocation()%></td>
                            <td><%=dtos.get(i).getAmount()%></td>
                            <td><%=dtos.get(i).getUserId()%></td>
                        </tr>
                        <%
                                }
                            }
                        %>

                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
