package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Odev03 extends TestBaseBeforeAfter {
    /*
     “https://demoqa.com/webtables” sayfasina gidin
     Headers da bulunan department isimlerini yazdirin
     sutunun basligini yazdirin
     Tablodaki tum datalari yazdirin
     Tabloda kac cell (data) oldugunu yazdirin
     Tablodaki satir sayisini yazdirin
     Tablodaki sutun sayisini yazdirin
     Tablodaki 3.kolonu yazdirin
     Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
     Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
     */
       @Test
    public void test01() {
           // “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
                 // Headers da bulunan department isimlerini yazdirin
        // tek tek
        System.out.println("Departman -> 1 : " +
                driver.findElement(By.cssSelector("div.rt-tbody>.rt-tr-group>.rt-tr.-odd>:nth-last-of-type(2)")).getText());
        System.out.println("Departman -> 2 : " +
                driver.findElement(By.cssSelector("div.rt-tbody>:nth-child(2)>.rt-tr.-even>:nth-last-of-type(2)")).getText());
        System.out.println("Departman -> 3 : " +
                driver.findElement(By.cssSelector("div.rt-tbody>:nth-child(3)>.rt-tr.-odd>:nth-last-of-type(2)")).getText());
           // hepsi
        List<WebElement> department = driver.findElements(By.cssSelector(".rt-tbody>.rt-tr-group>:nth-last-of-type(1)>:nth-child(6)"));
        System.out.println("Departman isimler -> ");
        for (WebElement w : department) {
               System.out.println(w.getText());
        }
                    // sutunun basligini yazdirin
        WebElement sutunBasligi = driver.findElement(By.cssSelector(".rt-table>.rt-thead.-header>.rt-tr>:nth-child(6)"));
        System.out.println("Sutun Basligi Departman -> " + sutunBasligi.getText());
           System.out.println("Butun Basliklar --------------------------------------------------------------");
        List<WebElement> basliklar = driver.findElements(By.cssSelector(".rt-table>.rt-thead.-header"));
        for (WebElement w : basliklar) {
               System.out.println(w.getText());
        }
                    // Tablodaki tum datalari yazdirin
        List<WebElement> tableData = driver.findElements(By.cssSelector(".rt-tbody>.rt-tr-group"));
        System.out.println("Tablodaki Butun Datalar ---------------------------------------------------------");
        tableData.forEach(t -> System.out.println(t.getText()));
                    //Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> cellSayisi = driver.findElements(By.cssSelector(".rt-tbody>.rt-tr-group>:nth-last-of-type(1)>.rt-td"));
        System.out.println("Table cell Sayisi -> " + cellSayisi.size());
                    //Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = driver.findElements(By.cssSelector(".rt-tbody>.rt-tr-group"));
        System.out.println("Tablodaki Satir sayisi -> " + satirSayisi.size());
                    //Tablodaki sutun sayisini yazdirin
        List<WebElement> SutunSayisi = driver.findElements(By.cssSelector(".rt-thead.-header>.rt-tr>.rt-th.rt-resizable-header.-cursor-pointer"));
        System.out.println("Tablodaki Sutun Sayisi -> " + SutunSayisi.size());
        // baslikSutunSayisi.forEach(t -> System.out.println(t.getText()));  // ayni zamanda baslik isimlerini de verir.
                 //Tablodaki 3.kolonu yazdirin
        List<WebElement> kolon3 = driver.findElements(By.cssSelector(".rt-tbody>.rt-tr-group>:nth-last-of-type(1)>:nth-child(3)"));
        System.out.println("Kolon3 Data Age -> ");
        kolon3.forEach(t -> System.out.println(t.getText()));
              //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        WebElement kierraSalary = driver.findElement(By.cssSelector(".rt-tbody>:nth-child(3)>.rt-tr.-odd>:nth-last-of-type(3)"));
        System.out.println("Kierra Salary -> " + kierraSalary.getText());
                 // Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
        table(2, 2);
    }

    public void table(int row, int column) { // method
           WebElement cell = driver.findElement(By.cssSelector(".rt-tbody>:nth-child(" + row + ")>:nth-child(1)>:nth-child(" + column + ")"));
           System.out.println(row + ". satir " + column + " . sutundaki data -> " + cell.getText());
    }
}