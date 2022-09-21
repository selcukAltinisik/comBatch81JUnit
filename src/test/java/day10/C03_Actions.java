package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){
        //  - Amazon sayfasına gidelim.
        driver.get("https://amazon.com");
        //  - Account menüsünden create a list linkine tıklayalım.
        WebElement accountList = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        /*
        Bir web sitesinde bir mouse ile açılan bir web elemntine ulaşmak istersek
        actions.moveToElement() method'unu kullanmamız gerekir. Aksi takdirde
        HTML kodları arasında Web Elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'i fırlatır
         */


    }

}
