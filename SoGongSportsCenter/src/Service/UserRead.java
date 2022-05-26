package Service;

import Persistence.DAO.AdminDAO;
import Persistence.DAO.InstructorDAO;
import Persistence.DAO.MemberDAO;
import Persistence.DAO.UserDAO;
import Persistence.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserRead extends UserManagement {
    public UserRead(UserDAO userDAO, AdminDAO adminDAO, InstructorDAO instructorDAO, MemberDAO memberDAO){
        super(userDAO, adminDAO, instructorDAO, memberDAO);
    }

    public List<UserDTO> userDataResultByName(String name){
        return userDAO.selectUserByName(name);
    }

    public List<UserDTO> userDataResultByType(String userType){
        if(userType.equals("admin")){
            return adminDAO.selectUser();
        }else if(userType.equals("instructor")){
            return instructorDAO.selectUser();
        } else if (userType.equals("member")) {
            return memberDAO.selectUser();
        }else{
            return new ArrayList<>();
        }
    }

    public List<UserDTO> userDataResultAll(){
        return userDAO.selectUser();
    }
}
