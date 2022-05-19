package Service;

import Persistence.DAO.*;
import Persistence.DTO.InstructorDTO;
import Persistence.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBConfig dbConfig = new DBConfig();
        UserDAO userDAO = new UserDAO(dbConfig.getConnection());

        // 테스트 완료
        // DAO 사용시 생성자로 connection 객체를 파라미터로 줘야함

        /*List<UserDTO> userDTOList = userDAO.selectUser();
        for(UserDTO userDTO : userDTOList){
            System.out.printf(userDTO.getUserName());
        }*/
        AdminDAO adminDAO = new AdminDAO(dbConfig.getConnection());
        MemberDAO memberDAO = new MemberDAO(dbConfig.getConnection());

        /*List<UserDTO> adminDAOS = adminDAO.selectUser();
        for (UserDTO userDTO : adminDAOS){
            System.out.printf(userDTO.getUserType());
        }*/

        InstructorDAO instructorDAO = new InstructorDAO(dbConfig.getConnection());
        /*List<UserDTO> adminDTOS = adminDAO.selectUser();
        for(UserDTO userDTO : adminDTOS){
            System.out.printf(userDTO.getUserName());
        }*/

/*        List<InstructorDTO> instructorDTOS = instructorDAO.selectInstructor();
        for(InstructorDTO instructorDTO : instructorDTOS){
            System.out.println(instructorDTO.getInstructorId());
        }*/

        /*List<UserDTO> memberDTOS = memberDAO.selectUser();
        for(UserDTO userDTO : memberDTOS){
            System.out.println(userDTO.getUserName());
        }*/

        userDAO.createUser(1, "asd", "asdf","member");

        /*adminDAO.createAdmin(120);*/

        /*memberDAO.createMember(120);*/

        instructorDAO.createInstructor(1, 2); // 생성시 cascade 있음 user 생성후 instructor 생성
    }
}
