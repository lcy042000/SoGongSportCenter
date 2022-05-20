package Service;

import Boundary.SaleView;
import Persistence.DAO.SaleDAO;
import Persistence.DTO.SaleDTO;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SaleDAO saleDAO = new SaleDAO();
        SaleManagementService saleManagementService = new SaleManagementService(saleDAO);
        SaleView saleView = new SaleView();

        List<SaleDTO> saleDTOList = saleManagementService.findSalesByLesson("asdf");
        saleView.printLessonSale(saleDTOList);


        saleDTOList = saleManagementService.findSalesByPeriod(Date.valueOf("2022-05-17"), Date.valueOf("2022-05-30"));
        saleView.printPeriodSale(saleDTOList);
    }
}
