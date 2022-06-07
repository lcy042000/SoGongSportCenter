package Service;

import Persistence.DAO.AdminDAO;
import Persistence.DAO.InstructorDAO;
import Persistence.DAO.MemberDAO;
import Persistence.DAO.UserDAO;

public class UserManagement {
    protected UserDAO userDAO;
    protected AdminDAO adminDAO;
    protected InstructorDAO instructorDAO;
    protected MemberDAO memberDAO;

    public UserManagement(UserDAO userDAO, AdminDAO adminDAO, InstructorDAO instructorDAO, MemberDAO memberDAO){
        this.userDAO = userDAO;
        this.adminDAO = adminDAO;
        this.instructorDAO = instructorDAO;
        this.memberDAO = memberDAO;
    }
}
