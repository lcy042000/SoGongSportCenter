package Service;

import Persistence.DAO.LessonDAO;
import Persistence.DAO.SaleDAO;
import Persistence.DAO.UserDAO;
import Persistence.DTO.SaleDTO;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class LessonManagementService {
    private SaleDAO saleDAO;
    private UserDAO userDAO;
    private LessonDAO lessonDAO;

    public LessonManagementService(UserDAO userDAO,SaleDAO saleDAO,LessonDAO lessonDAO)
    {
        this.userDAO = userDAO;
        this.saleDAO = saleDAO;
        this.lessonDAO = lessonDAO;
    }

    public boolean createLesson(HashMap<String,Object> map)
    {
        boolean result = lessonDAO.createLesson(map);
        return result;
    }

    public boolean lectureRegistration(int id,int userId,int lessonId)
    {

        boolean result = lessonDAO.lectureRegistration(id,userId,lessonId);
        //saleDAO.insertSalse()
        return result;
    }

    public List<SaleDTO> findSalesByPeriod(Date start, Date end) {
        List<SaleDTO> saleDTOList = saleDAO.selectSalesByPeriod(start, end);
        return saleDTOList;
    }

    public List<SaleDTO> findSalesByLesson(String lessonName) {
        List<SaleDTO> saleDTOList = saleDAO.selectSalesByLesson(lessonName);
        return saleDTOList;
    }
}
