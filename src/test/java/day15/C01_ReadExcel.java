package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //  Excel tablosundaki tüm tabloyu konsola yazdırınız.
        int sonSatir = workbook.getSheet("Sayfa2").getLastRowNum();
        String tablo = "";
        for (int i = 0; i <=sonSatir ; i++) {
            tablo = workbook.getSheet("Sayfa2").getRow(i).getCell(0).toString()+", "
                    +workbook.getSheet("Sayfa2").getRow(i).getCell(0).toString()+", "
                    +workbook.getSheet("Sayfa2").getRow(i).getCell(0).toString()+", "
                    +workbook.getSheet("Sayfa2").getRow(i).getCell(0).toString();
            System.out.printf(tablo);
        }

        /*
        for (int i = 0; i <sonData ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(workbook.getSheet("Sayfa1").getRow(i).getCell(j)+", ");
            }
            System.out.println("");
        }
         */

    }
}
