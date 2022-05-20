package Persistence.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class AttachedFileController {

    private Connection conn;

    public AttachedFileController(){
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
