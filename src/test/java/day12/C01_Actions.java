package day12;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        //Automationexercises.com adresine gidelim
        driver.get("https://www.automationexercise.com");

        //product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        //ilk ürünü tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart']) [1]")).click();

    }
}
