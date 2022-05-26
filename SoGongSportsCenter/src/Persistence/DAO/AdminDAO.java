package Persistence.DAO;

import Persistence.DTO.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends UserDAO {

    public AdminDAO(Connection conn){
        super(conn);
    }

    @Override
    public List<UserDTO> selectUser() {
        List<UserDTO> adminDTOS = new ArrayList<>();
        String sql = "SELECT * FROM USER where userType = 'admin'";
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
                adminDTOS.add(userDTO);
            }
        }catch (SQLException e) {
            System.out.printf("SELECT ADMIN ERROR");
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
                System.out.println("SQL ADMIN CLOSE ERROR");
            }
        }
        return adminDTOS;
    }

    public void createAdmin(int userId){
        PreparedStatement pstmt = null;
        String sql = "Insert Into Admin (userId) Values(?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("CREATE ADMIN ERROR");
        }finally {
            try{
                if(conn != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch(SQLException e){
                System.out.println("SQL ADMIN CLOSE ERROR");
            }
        }
    }
}