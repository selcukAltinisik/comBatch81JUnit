package day10;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    //  Yeni bir class olusturalim: MouseActions1
    //  https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //  3- Cizili alan uzerinde sag click yapalim
    //  Alert’te cikan yazinin “You selected a context menu” oldugunu
    //  test edelim.
    //  Tamam diyerek alert’i kapatalim
    //  Elemental Selenium linkine tiklayalim
    //  Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test1(){
        //  https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //  3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        //  Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertMessage = "You selected a context menu";
        String actualAlertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertMessage,actualAlertMessage);

        //  Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //  Elemental Selenium linkine tiklayalim
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        elementalSelenium.click();

        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        //  Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedh1Text = "Elemental Selenium";
        String actualh1Text = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedh1Text,actualh1Text);




    }

}
