package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Odev01 extends TestBaseBeforeAfter {
        @Test
        public void test1() throws InterruptedException {

             //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
             driver.get("http://webdriveruniversity.com/Actions");

             // 2- Hover over Me First" kutusunun ustune gelin
             WebElement hoverOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
             Actions actions = new Actions(driver);
             actions.moveToElement(hoverOverMeFirst).perform();

             //Link 1" e tiklayin
             Thread.sleep(2000);
             WebElement link1 = driver.findElement(By.xpath("(//a[text()='Link 1'])[1]"));
             link1.click();

             //Popup mesajini yazdirin
             System.out.println("pop-up message : " + driver.switchTo().alert().getText());

             //Popup'i tamam diyerek kapatin
             Thread.sleep(2000);
             driver.switchTo().alert().accept();

             //“Click and hold" kutusuna basili tutun
             Thread.sleep(2000);
             WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
             actions.clickAndHold(clickAndHold).perform();

             //7-“Click and hold" kutusunda cikan yaziyi yazdirin
             System.out.println("Click and Hold Box : " + clickAndHold.getText());

             //8- “Double click me" butonunu cift tiklayin
             Thread.sleep(2000);
             WebElement doubleClickMe = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
             actions.doubleClick(doubleClickMe).perform();

        }
}
