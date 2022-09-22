package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_Iframe {
      /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */


    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() throws InterruptedException {
        //driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

       //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());

       //○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr"));    //  Frame'e geçiş yapmadan önce orayı id ile locate edelim.
        driver.switchTo().frame(textBox);   //  Locate ettiğimiz frame'e geçmek için bu method'u kallanırız.

        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        Thread.sleep(2000);
        textBoxFrame.clear();

        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba Dünya!");

       //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin

        driver.switchTo().defaultContent(); //  iframe'den çıkıp ana sayfaya geçmek için bu method kullanılır..

        WebElement elemental= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());


    }

}
