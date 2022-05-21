package Persistence.DAO;

import Persistence.DTO.AnnouncementDTO;
import Persistence.DTO.AttachedFileDTO;

import java.sql.*;
import java.util.List;

public class AttachedFileDAO {

    private Connection conn;

    public AttachedFileDAO(){
        try{
            String dbURL = "jdbc:mysql://localhost:3306/OOSE";
            String dbId = "root";
            String dbPassword = "db042000@";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createAttachedFile(AttachedFileDTO attachedFile, int announcementId){

        PreparedStatement pstmt = null;

        String SQL = "INSERT INTO attachedFile " +
                "Announcement_ID," +
                "AttachedFile)" +
                "VALUES (?, ?);";

        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, attachedFile.getAnnouncementId());
            pstmt.setBlob(2, attachedFile.getAttachedFile());

            int result = pstmt.executeUpdate();

            if(result != 1){
                System.out.println("생성에 실패하였습니다.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null) {pstmt.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    public List<AttachedFileDTO> readAttachedFile(int announcementId){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<AttachedFileDTO> attachedFileDTOS = null;

        String SQL = "SELECT * FROM attachedfile WHERE announcementId=?";

        try{
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int attachedFileId = rs.getInt("attachedFileId");
                int announcementIdResult = rs.getInt("announcementId");
                Blob attachedFile = rs.getBlob("AttachedFile");

                attachedFileDTOS.add(new AttachedFileDTO(attachedFileId, announcementIdResult, attachedFile));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null) {pstmt.close();}
                if(rs != null) {rs.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return attachedFileDTOS;
    }

//    public void deleteAttachedFile(int announcementId){
//
//    }
}
