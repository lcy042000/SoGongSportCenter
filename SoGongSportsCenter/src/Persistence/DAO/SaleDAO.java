package Persistence.DAO;

import Persistence.DTO.SalesDTO;

import java.sql.*;

public class SalesDAO {

    private Connection conn;

    public SalesDAO(){
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

    public void createAnnouncement(SalesDTO announcement){

        PreparedStatement pstmt;;

        String SQL = "INSERT INTO announcement " +
                "Announcement_Title," +
                "Announcement_Content," +
                "Announcement_Writer_ID," +
                "Announcement_Writer_Name," +
                "Write_Date," +
                "IsAttachedFile," +
                "Hits)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, announcement.getAnnouncementTitle());
            pstmt.setString(2, announcement.getAnnouncementContent());
            pstmt.setInt(3, announcement.getAnnouncementWriterId());
            pstmt.setString(4, announcement.getAnnouncementWriterName());
            pstmt.setDate(5, (Date) announcement.getWriteDate());
            pstmt.setInt(6, announcement.getIsAttachedFile());
            pstmt.setInt(7, 0);

            int result = pstmt.executeUpdate();

            if(result != 1){
                System.out.println("생성에 실패하였습니다.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    public void updateAnnouncement(int announcementId, Announcement announcement){
//
//    }
//
//    public Announcement readAnnouncement(int announcementId){
//
//    }
//
//    public void deleteAnnouncement(int announcementId){
//
//    }
//
//    public List<Announcement> readAnnouncementList(int pageNum){
//
//    }
//
//    public void createAttachedFile(AttachedFile attachedFile, int announcementId){
//
//    }
//
//    public AttachedFile readAttachedFile(int announcementId){
//
//    }
//
//    public void deleteAttachedFile(int announcementId){
//
//    }
}
