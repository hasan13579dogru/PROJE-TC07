package testngTeam05.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
    //satır ve sutun syılarını girdiğimizde, o hucredeki veriyi return eden method
    public String getCellData(int satir,int sutun){
        Cell cell= sheet.getRow(satir).getCell(sutun);
        return cell.toString();

    }
    //Exceldeki satır sayısını return eden method
    public int rowCount(){
        return sheet.getLastRowNum();
    }
    //Excel'e yazi yazma methodu silmeyin arkadaslar
    public void writeCell(int satir,int sutun,String dosyaYolu, String value){
        Cell cell = sheet.getRow(satir).createCell(sutun);
        cell.setCellValue(value);

        try {
            FileOutputStream fos = new FileOutputStream(dosyaYolu);
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Dosya bulunamadı: " + dosyaYolu, e);
        } catch (IOException e) {
            throw new RuntimeException("Dosyaya yazarken bir hata oluştu.", e);
        }
    }

}