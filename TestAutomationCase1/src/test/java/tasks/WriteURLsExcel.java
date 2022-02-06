package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import pages.*;

//class to write into excel
public class WriteURLsExcel implements Task {
    private final String category;
    public static XSSFWorkbook workbook = new XSSFWorkbook();                     //create one excel workbook

    //constructor
    public WriteURLsExcel(String category) {
        this.category = category;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        String path = ".\\urlList.xlsx";                                         //set path to write the file
        XSSFSheet sheet = createSheet(workbook,category);

        writeToFile(workbook,sheet,category,path);
    }

    //method to create a sheet
    public static XSSFSheet createSheet(XSSFWorkbook workbook, String category){
        XSSFSheet spreadsheet = workbook.createSheet(category);                       //creating sheet object
        Row header = spreadsheet.createRow(0);                                 //setting the first row
        Cell nameCell = header.createCell(0);                                       //creating cell row
        nameCell.setCellValue("Category Name");                                       //enter header value
        Cell urlCell = header.createCell(1);
        urlCell.setCellValue("URL");                                                  //enter header value
        return spreadsheet;
    }

    //method to write into sheet
    public static void writeToFile(XSSFWorkbook workbook,XSSFSheet spreadsheet,String category,String path){
        List<String> listOfLinks = CampaignPage.getLinksList(category);

        int rowNum=1;
        for (String link : listOfLinks){                                                 //for each link in the campaigns link list
            Row row = spreadsheet.createRow(rowNum);
            createList(link,row,category);                                       //using custom method to set links to cells
            rowNum++;
        }

        File file = new File(path);                                              //writing to file
        try {
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to set cell values for each row
    public static void createList(String link,Row row,String category){
        row.createCell(0).setCellValue(category);
        Cell cell = row.createCell(1);
        cell.setCellValue(link);
    }

    public static WriteURLsExcel writeToExcel(String category){
        return new WriteURLsExcel(category);
    }
}
