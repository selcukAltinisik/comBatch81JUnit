package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
    public class Case02 {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
        9. Click 'Delete Account' button
        10. Verify that 'ACCOUNT DELETED!' is visible
        1. Tarayıcıyı başlatın
        2. 'http://automationexercise.com' url'sine gidin
        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        6. Doğru e-posta adresini ve şifreyi girin
        7. 'Giriş' düğmesini tıklayın
        8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        9. 'Hesabı Sil' düğmesini tıklayın
        10. 'HESAP SİLİNDİ!' görünür
         */
        static WebDriver driver;
        @BeforeClass
        public static void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //2. 'http://automationexercise.com' url'sine gidin
            driver.get("http://automationexercise.com");
        }
        @Test
        public void test(){
            // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
            Assert.assertTrue("Page is visible", driver.getCurrentUrl().contains("https://automationexercise.com/"));
            //Anasayfanın başarılı kontrolünu url üzerinden yapmak gerekiyor
            //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
            driver.findElement(By.xpath("//a[@href='/login']")).click();
            // 5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
            Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
            //6. Doğru e-posta adresini ve şifreyi girin
            driver.findElement(By.xpath("//*[@name='email'][1]")).sendKeys("zzz@gmail.com");
            driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("123456789");
            // 7. 'Giriş' düğmesini tıklayın
            driver.findElement(By.xpath("//*[text()='Login']")).click();
            //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed());
            //9. 'Hesabı Sil' düğmesini tıklayın
            driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
            //10. 'HESAP SİLİNDİ!' görünür
            Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]")).isDisplayed());
        }
        @AfterClass
        public static void tearDown(){
            driver.close();
        }

}
