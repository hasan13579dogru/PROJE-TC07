package testngTeam05.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReader {
    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu, String sayfaIsmi)  {//constructor

        try {
           FileInputStream fis = new FileInputStream(dosyaYolu);
            workbook= WorkbookFactory.create(fis);
            sheet=workbook.getSheet(sayfaIsmi);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //satır ve sutun sayılarını girdiğimizde, o hucredeki veriyi return eden method
    public String getCellData(int satir,int sutun){
        Cell cell= sheet.getRow(satir).getCell(sutun);
        return cell.toString();

    }
    //Exceldeki satır sayısını return eden method
    public int rowCount(){
        return sheet.getLastRowNum();
    }


    //Exceldeki satıra veri yazdıran method
    public void writeCell(int satir,int sutun,String dosyaYolu,String value){

        Cell cell = sheet.getRow(satir).createCell(sutun);
        cell.setCellValue(value);
        try (FileOutputStream fos = new FileOutputStream(dosyaYolu)) {
            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
