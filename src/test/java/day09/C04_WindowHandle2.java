package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle2 {

    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
    https://the-internet.herokuapp.com/windows adresine gidin.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    Click Here butonuna basın.
    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
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
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());

        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //    Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        Thread.sleep(2000);
        /*
        Bir web sitesine gittiğinizde bir Web Elementi tıkladığınızda yeni bir sekme ya da pencere açılırsa
        buyeni açılan sekmenin handle değerini bulabilmek için driver.getWindowHandles() methodunu bir ArrayList'e
        atıp bütün sayfaların listesine ulaşabilirim. İlk açtığım pencerenin indexi 0(sıfır)'dır. İkinci açılan sekmenin
        indexi 1'dir. Ve ikinci açılan pencerede ya da sekmede işlem yapabilmek için
        driver.switchTo().window(listAdı.get(1)) methodunu kullanırız.
         */

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
        */


        //    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(),"New Window" );

        //    Sayfadaki textin “New Window” olduğunu doğrulayın.....
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(2000);
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet", driver.getTitle());

    }

}
