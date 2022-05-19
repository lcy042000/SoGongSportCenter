package Persistence.DAO;

import Persistence.DTO.UserDTO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    protected Connection conn;

    public UserDAO(Connection conn){
        this.conn = conn;
    }

    public List<UserDTO> selectUser(){
        List<UserDTO> userDTOS = new ArrayList<>();
        String sql = "SELECT * FROM USER";
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
                userDTOS.add(userDTO);
            }
        }catch (SQLException e) {
            System.out.printf("SELECT USER ERROR");
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
                System.out.println("SQL USER CLOSE ERROR");
            }
        }
        return userDTOS;
    }

    public void createUser(int userId, String userPassword, String userName, String userType){
        PreparedStatement pstmt = null;
        String sql = "Insert Into User (userId, userPassword, userName, userType) Values(?,?,?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, userPassword);
            pstmt.setString(3, userName);
            pstmt.setString(4, userType);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("CREATE USER ERROR");
        }finally {
            try{
                if(conn != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch(SQLException e){
                System.out.println("SQL USER CLOSE ERROR");
            }
        }
    }
}