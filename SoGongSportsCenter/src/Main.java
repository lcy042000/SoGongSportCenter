import Boundary.SaleView;
import Persistence.DAO.AnnouncementDAO;
import Persistence.DAO.DBConfig;
import Persistence.DAO.InstructorDAO;
import Persistence.DAO.SaleDAO;
import Persistence.DTO.AnnouncementDTO;
import Persistence.DTO.InstructorDTO;
import Persistence.DTO.SaleDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InstructorDAO instructorDAO = new InstructorDAO(new DBConfig().getConnection());
        List<InstructorDTO> instructorList = instructorDAO.selectInstructor();

//        AnnouncementDTO dto = new AnnouncementDTO("Hello", "lorem", "Lee",
//                Date.valueOf(LocalDate.now()), 0, 0);

        //dao.createAnnouncement(dto);
    }
}
