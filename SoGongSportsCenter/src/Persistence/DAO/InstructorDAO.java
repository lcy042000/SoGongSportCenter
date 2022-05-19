package Persistence.DAO;

import Persistence.DTO.InstructorDTO;
import Persistence.DTO.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO extends UserDAO {
    public InstructorDAO(Connection conn){
        super(conn);
    }

    @Override
    public List<UserDTO> selectUser() {
        List<UserDTO> instructorDTOS = new ArrayList<>();
        String sql = "SELECT * FROM USER where userType = 'instructor'";
        Statement stmt= null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                UserDTO userDTO = new UserDTO();
                int userId = rs.getInt("userId");
                String userPassword = rs.getString("userPassword");
                String userName = rs.getString("userName");
                String userType = rs.getString("userType");

                userDTO.setUserId(userId);
                userDTO.setUserPassword(userPassword);
                userDTO.setUserName(userName);
                userDTO.setUserType(userType);
                instructorDTOS.add(userDTO);
            }
        }catch (SQLException e) {
            System.out.printf("SELECT INSTRUCTOR ERROR");
        }finally {
            try{
                if(conn != null && !rs.isClosed()){
                    rs.close();
                }
                if(conn != null && !stmt.isClosed()){
                    rs.close();
                }
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch(SQLException e){
                System.out.println("SQL INSTRUCTOR CLOSE ERROR");
            }
        }
        return instructorDTOS;
    }

    public List<InstructorDTO> selectInstructor() {
        List<InstructorDTO> instructorDTOS = new ArrayList<>();
        String sql = "SELECT user.userId, userPassword, userName, userType, instructorId FROM USER JOIN INSTRUCTOR ON user.userId = instructor.userId where userType = 'instructor'";
        Statement stmt= null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                InstructorDTO instructorDTO = new InstructorDTO();
                int userId = rs.getInt("userId");
                String userPassword = rs.getString("userPassword");
                String userName = rs.getString("userName");
                String userType = rs.getString("userType");
                int instructorId = rs.getInt("instructorId");

                instructorDTO.setUserId(userId);
                instructorDTO.setUserPassword(userPassword);
                instructorDTO.setUserName(userName);
                instructorDTO.setUserType(userType);
                instructorDTO.setInstructorId(instructorId);
                instructorDTOS.add(instructorDTO);
            }
        }catch (SQLException e) {
            System.out.printf("SELECT INSTRUCTOR ALL ERROR");
        }finally {
            try{
                if(conn != null && !rs.isClosed()){
                    rs.close();
                }
                if(conn != null && !stmt.isClosed()){
                    rs.close();
                }
            }
            catch(SQLException e){
                System.out.println("SQL INSTRUCTOR CLOSE ERROR");
            }
        }
        return instructorDTOS;
    }

    public void createInstructor(int userId, int instructorId){
        PreparedStatement pstmt = null;
        String sql = "Insert Into Instructor (userId, instructorId) Values(?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, instructorId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("CREATE INSTRUCTOR ERROR");
        }finally {
            try{
                if(conn != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch(SQLException e){
                System.out.println("SQL INSTRUCTOR CLOSE ERROR");
            }
        }
    }
}