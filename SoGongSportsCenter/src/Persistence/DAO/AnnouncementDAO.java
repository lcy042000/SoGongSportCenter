package Persistence.DAO;

import Persistence.DTO.AnnouncementDTO;

import java.sql.*;

public class AnnouncementDAO {

    private Connection conn;

    public AnnouncementDAO(){
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

    public void createAnnouncement(AnnouncementDTO announcement) {

        PreparedStatement pstmt = null;

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
            //pstmt.setInt(3, announcement.getAnnouncementWriterId());
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
        }finally {
            try{
                if(pstmt != null) {pstmt.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

//    public void updateAnnouncement(int announcementId, Announcement announcement){
//
//    }
//
    public AnnouncementDTO readAnnouncement(int announcementId){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        AnnouncementDTO announcement = null;

        String SQL = "SELECT * FROM announcement WHERE announcementId=?";

        try{
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int announcementIdResult = rs.getInt("announcementId");
                String announcementTitle = rs.getString("announcementTitle");
                String announcementContent = rs.getString("announcementContent");
                int announcementWriterId = rs.getInt("announcementWriterId");
                String announcementWriterName = rs.getString("announcementWriterName");
                int hits = rs.getInt("hits");
                int isAttachedFile = rs.getInt("isAttachedFile");
                Date writeDate = rs.getDate("writeDate");

                return new AnnouncementDTO(announcementTitle, announcementContent, announcementWriterName, writeDate, isAttachedFile, hits);
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

        return announcement;
    }

//    public void deleteAnnouncement(int announcementId){
//
//    }
//
//    public List<Announcement> readAnnouncementList(int pageNum){
//
//    }
//
}
