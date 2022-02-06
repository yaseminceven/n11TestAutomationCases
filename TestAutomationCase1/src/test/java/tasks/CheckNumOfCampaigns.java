package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

//class to check number of campaigns
public class CheckNumOfCampaigns implements Task {
    private final String category;

    //constructor
    public CheckNumOfCampaigns(String category) {
        this.category = category;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            numOfCampaigns(category);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //method to find number of campaigns from excel sheet
    public static int numOfCampaigns(String category) throws IOException {
        FileInputStream fis =new FileInputStream(".\\urlList.xlsx");
        //creating workbook to refer to excel file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //creating a Sheet object to retrieve
        XSSFSheet sheet=wb.getSheet(category);
        int rowCount = sheet.getLastRowNum();
        return rowCount;
    }

    //method to check number of campaigns
    public static Integer check(String category) throws IOException {
        return CheckNumOfCampaigns.numOfCampaigns(category);
    }

}


