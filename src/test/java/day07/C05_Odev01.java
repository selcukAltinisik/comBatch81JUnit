package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_Odev01 {
      /*
    1. http://zero.webappsecurity.com/ Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */

    static WebDriver driver;

    @Before
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }
    @AfterClass
    public static void tearDown() {
        //  driver.close();
    }
    @Test
    public void test1() {   //  Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
    }
    @Test
    public void test2() {   //  Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");

    }
    @Test
    public void test3() {   //  Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password.");
    }
    @Test
    public void test4() {   //  Sign in tusuna basin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
    }
    @Test
    public void test5() {   //  Pay Bills sayfasina gidin

    }
    @Test
    public void test6() {   //  “Purchase Foreign Currency” tusuna basin

    }
    @Test
    public void test7() {   //  “Currency” drop down menusunden Eurozone’u secin

    }
    @Test
    public void test8() {   //  “amount” kutusuna bir sayi girin

    }
    @Test
    public void test9() {   //  “US Dollars” in secilmedigini test edin

    }
    @Test
    public void test10() {   //  “Selected currency” butonunu secin

    }

    @Test
    public void test11() {   //  “Selected currency” butonunu secin

    }
    @Test
    public void test12() {   //  “Selected currency” butonunu secin

    }
    @Test
    public void test13() {   //  “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

    }

}
