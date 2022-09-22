package day11;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import java.util.ArrayList;
import java.util.List;
public class Odev02 extends TestBaseBeforeAfter {

        @Test
        public void test1() throws InterruptedException {
            //https://html.com/tags/iframe/ sayfasina gidelim
            driver.get("https://html.com/tags/iframe/");

           //video’yu gorecek kadar asagi inin
           Actions actions =new Actions(driver);
           actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
           Thread.sleep(2000);

           //videoyu izlemek icin Play tusuna basin
           List<WebElement> iFrameList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
           driver.switchTo().frame(iFrameList.get(0));
           WebElement playButton = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
           playButton.click();
           Thread.sleep(2000);

           //videoyu calistirdiginizi test edin
           WebElement duraklatButonu = driver.findElement(By.xpath("//*[@title='Duraklat (k)']"));
           Assert.assertTrue(duraklatButonu.isDisplayed());

        }
    }
