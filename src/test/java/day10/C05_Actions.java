package day10;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {

    //  Yeni bir class olusturalim: MouseActions2
    //  https://demoqa.com/droppable adresine gidelim
    //  “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //  “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test1() throws InterruptedException {
        //  https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //  “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);

        Thread.sleep(2000);
        actions.dragAndDrop(dragMe,dropHere).perform();


        //  “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedText = "Dropped!";
        String actualText = dropHere.getText();
        Assert.assertEquals(expectedText,actualText);

    }

}
