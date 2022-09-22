package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        //  "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //  “create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //  “firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();

        String email = faker.internet().emailAddress();

        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-']) [1]"));

        /*
        Faker class'ını kullanma amacımız form doldurmamız gereken web sitelerinde defalarca kendi üreteceğimiz veriler yerine
        bizim için random veriler üretir ve işimizi kolaylaştırır.

        Faker class'ını kullanmak için mvnrespository.com adresinden java faker kütüphanesini aratır ve en çok kullanılanı
        pom.xml dosyamıza (dependencies tagları arasına) ekleriz. Sonra faker class'ından bir obje oluşturup;

        email için: faker.internet() methodunu kullanarak emailAddress() method'unu seçeriz.
        password: faker.internet().password()
        isim: faker.name().firstName()
        soyisim: faker.name().lastName()

        method'larını kullanırız.
        */

        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).

                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("29").
                sendKeys(Keys.TAB).sendKeys("May").
                sendKeys(Keys.TAB).sendKeys("1989").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();



        //  “email” giris kutusuna bir email yazin
        //  “email” onay kutusuna emaili tekrar yazin
        //  Bir sifre girin
        //  Tarih icin gun secin
        //  Tarih icin ay secin
        //  Tarih icin yil secin
        //  Cinsiyeti secin
        //  Kaydol butonuna basın


    }
}
