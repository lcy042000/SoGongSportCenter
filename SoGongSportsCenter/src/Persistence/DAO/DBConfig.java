package Persistence.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
    private Connection conn;
    private String dbURL = "jdbc:mysql://localhost:3306/sportcenter";
    private String dbId = "root";
    private String dbPassword = "alswhd11";

    public DBConfig(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            System.out.println(1231);
        }catch (Exception e){
            System.out.println(1231);
        }
    }

    public Connection getConnection(){
        return conn;
    }
}
