package Persistence.DAO;

import Persistence.DTO.SaleDTO;
import rsc.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

    private Connection conn;
    private Info info;
    public SaleDAO(){
        try{
            String dbURL = Info.dbURL;
            String dbId = Info.dbId;
            String dbPassword = Info.dbPassword;
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<SaleDTO> selectSalesByPeriod(Date start, Date end) {
        String SQL = "Select * from sales where time > ?  AND time < ?";

        List<SaleDTO> saleDTOList = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(Info.dbURL, Info.dbId, Info.dbPassword);
             PreparedStatement psmt = conn.prepareStatement(SQL)) {
             psmt.setDate(1, start);
             psmt.setDate(2, end);

            try (ResultSet rs = psmt.executeQuery()) {
                while (rs.next()) {
                    SaleDTO saleDTO = new SaleDTO();
                    saleDTO.setCenterName(rs.getString("centerName"));
                    saleDTO.setLessonName(rs.getString("lessonName"));
                    saleDTO.setTime(rs.getDate("time"));
                    saleDTO.setSales(rs.getInt("sales"));
                    saleDTOList.add(saleDTO);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return saleDTOList;
    }

    public List<SaleDTO> selectSalesByLesson(String lesson) {
        String SQL = "Select * from sales where lessonName = ?";

        List<SaleDTO> saleDTOList = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(Info.dbURL, Info.dbId, Info.dbPassword);
             PreparedStatement psmt = conn.prepareStatement(SQL)) {
            psmt.setString(1, lesson);

            try (ResultSet rs = psmt.executeQuery()) {
                while (rs.next()) {
                    SaleDTO saleDTO = new SaleDTO();
                    saleDTO.setCenterName(rs.getString("centerName"));
                    saleDTO.setLessonName(rs.getString("lessonName"));
                    saleDTO.setTime(rs.getDate("time"));
                    saleDTO.setSales(rs.getInt("sales"));
                    saleDTOList.add(saleDTO);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return saleDTOList;
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
