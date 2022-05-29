package Persistence.DAO;

import Persistence.DTO.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends UserDAO {
    public MemberDAO(Connection conn){
        super(conn);
    }

    @Override
    public List<UserDTO> selectUser() {
        List<UserDTO> memberDTOS = new ArrayList<>();
        String sql = "SELECT * FROM USER where userType = 'member'";
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
                memberDTOS.add(userDTO);
            }
        }catch (SQLException e) {
            System.out.printf("SELECT MEMBER ERROR");
        }finally {
            try{
                if(conn != null && !rs.isClosed()){
                    rs.close();
                }
                if(conn != null && !stmt.isClosed()){
                    stmt.close();
                }
            }
            catch(SQLException e){
                System.out.println("SQL ADMIN CLOSE ERROR");
            }
        }
        return memberDTOS;
    }

    public void createMember(int userId){
        PreparedStatement pstmt = null;
        String sql = "Insert Into Member (userId) Values(?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("CREATE MEMBER ERROR");
        }finally {
            try{
                if(conn != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch(SQLException e){
                System.out.println("SQL MEMBER CLOSE ERROR");
            }
        }
    }
}