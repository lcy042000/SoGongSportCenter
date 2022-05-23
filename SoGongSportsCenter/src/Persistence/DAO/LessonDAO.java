package Persistence.DAO;

import Persistence.DTO.SaleDTO;
import rsc.Info;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LessonDAO {

    private static final String insertLessonQuery = "INSERT INTO LESSON (id,name,classroom,price,instructor_id) VALUES (?,?,?,?,?)";
    private static final String lessonRegistrationQuery = "INSERT INTO LESSON_REGISTRATION_INFO (id,user_id,lesson_id,registration_date) VALUES (?,?,?,?)";
    private Connection conn;
    private Info info;

    public LessonDAO(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean createLesson(HashMap<String,Object> map)
    {

        try (Connection conn = DriverManager.getConnection(Info.dbURL, Info.dbId, Info.dbPassword);
             PreparedStatement psmt = conn.prepareStatement(insertLessonQuery)) {

            psmt.setInt(1, (int)map.get("lessonId"));
            psmt.setString(2, (String)map.get("lessonName"));
            psmt.setString(3, (String)map.get("classroom"));
            psmt.setInt(4, (int)map.get("price"));
            psmt.setInt(5, (int)map.get("instructorId"));

            int rowNumber = psmt.executeUpdate();
            System.out.println(rowNumber + "has changed");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean lectureRegistration(int id,int userId,int lessonId)
    {

        Date date = new Date(System.currentTimeMillis());

        try (Connection conn = DriverManager.getConnection(Info.dbURL, Info.dbId, Info.dbPassword);
             PreparedStatement psmt = conn.prepareStatement(lessonRegistrationQuery)) {

            psmt.setInt(1, id);
            psmt.setInt(2, userId);
            psmt.setInt(3, lessonId);
            psmt.setDate(4, date);

            int rowNumber = psmt.executeUpdate();
            System.out.println(rowNumber + "has changed");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;

    }




}
