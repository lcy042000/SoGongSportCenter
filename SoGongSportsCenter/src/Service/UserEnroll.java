package Service;

import Persistence.DAO.AdminDAO;
import Persistence.DAO.InstructorDAO;
import Persistence.DAO.MemberDAO;
import Persistence.DAO.UserDAO;
import Persistence.DTO.UserDTO;

import java.util.List;

import static Service.Message.*;

public class UserEnroll extends UserManagement{


    public UserEnroll(UserDAO userDAO, AdminDAO adminDAO, InstructorDAO instructorDAO, MemberDAO memberDAO){
        super(userDAO, adminDAO, instructorDAO, memberDAO);
    }

    public String userEnroll(UserDTO userDTO){
        String message = inputValidation(userDTO.getUserId(), userDTO.getUserPassword());
        if(message.equals(ENROLL_SUC)){
            if(userDTO.getUserType().equals("admin")){
                userDAO.createUser(userDTO.getUserId(), userDTO.getUserPassword(), userDTO.getUserPassword(), userDTO.getUserType());
                adminDAO.createAdmin(userDTO.getUserId());
            }else if(userDTO.getUserType().equals("instructor")){
                userDAO.createUser(userDTO.getUserId(), userDTO.getUserPassword(), userDTO.getUserPassword(), userDTO.getUserType());
                instructorDAO.createInstructor(userDTO.getUserId(), 0);
            }else if(userDTO.getUserType().equals("member")){
                userDAO.createUser(userDTO.getUserId(), userDTO.getUserPassword(), userDTO.getUserPassword(), userDTO.getUserType());
                memberDAO.createMember(userDTO.getUserId());
            }else{
                message = ENROLL_INVALID_TYPE_VALUE;
            }
        }

        return message;
    }

    public String inputValidation(int userId, String userPassword){
        if(userId == 0 || userPassword == null){
            return ENROLL_INVALID_ACCOUNT_VALUE;
        }
        List<UserDTO> userDTOS = userDAO.selectUser();
        for(UserDTO userDTO : userDTOS){
            if(userDTO.getUserId() == userId){
                return ENROLL_EXIST_ID;
            }
        }
        return ENROLL_SUC;
    }
}
