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
        AdminDAO adminDAO = new AdminDAO(dbConfig.getConnection());
        MemberDAO memberDAO = new MemberDAO(dbConfig.getConnection());
        InstructorDAO instructorDAO = new InstructorDAO(dbConfig.getConnection());
        List<InstructorDTO> list = instructorDAO.selectInstructor();

        // 테스트 완료
        // DAO 사용시 생성자로 connection 객체를 파라미터로 줘야함

        /*List<UserDTO> userDTOList = userDAO.selectUser();
        for(UserDTO userDTO : userDTOList){
            System.out.printf(userDTO.getUserName());
        }*/

        /*List<UserDTO> adminDAOS = adminDAO.selectUser();
        for (UserDTO userDTO : adminDAOS){
            System.out.printf(userDTO.getUserType());
        }*/


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

        /*userDAO.createUser(1, "asd", "asdf","member");*/

        /*adminDAO.createAdmin(120);*/

        /*memberDAO.createMember(150);*/

        /*instructorDAO.createInstructor(1, 2);*/ // 생성시 cascade 있음 user 생성후 instructor 생성


        UserEnroll userEnroll = new UserEnroll(userDAO, adminDAO, instructorDAO, memberDAO);

        UserRead userRead = new UserRead(userDAO, adminDAO, instructorDAO, memberDAO);

        /*UserDTO userDTO1 = new UserDTO(130, "ggg", "ggg", "admin");*/
        /*System.out.println(userEnroll.userEnroll(userDTO1));*/

        /*UserDTO userDTO2 = new UserDTO(131, "hhh", "hhh", "instructor");
        System.out.println(userEnroll.userEnroll(userDTO2));*/

        /*UserDTO userDTO3 = new UserDTO(132, "hhh", "hhh", "member");
        System.out.println(userEnroll.userEnroll(userDTO3));*/
//
//        List<UserDTO> arr1 = userRead.userDataResultAll();
//        for(UserDTO dto : arr1){
//            System.out.println(dto.getUserId());
//        }
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        List<UserDTO> arr2 = userRead.userDataResultByType("admin");
//        for(UserDTO dto : arr2){
//            System.out.println(dto.getUserId());
//        }
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        List<UserDTO> arr3 = userRead.userDataResultByType("member");
//        for(UserDTO dto : arr3){
//            System.out.println(dto.getUserId());
//        }
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        List<UserDTO> arr4 = userRead.userDataResultByType("instructor");
//        for(UserDTO dto : arr4){
//            System.out.println(dto.getUserId());
//        }
    }
}
