package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {

    @Test
    public void implicitlyWaitTest1() {
        //  Bir class olusturun : WaitTest
        //  Iki tane metod olusturun : implicitWait() , explicitWait()

        //  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //  Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //  “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //  Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        //  It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());


    }

    @Test
    public void explicitWaitTest2() {

        //  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //  Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //  “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGoneWE.isDisplayed());

        //  Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //  It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());




    }
}
