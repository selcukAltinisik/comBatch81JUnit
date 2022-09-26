package day15;

import io.netty.handler.codec.http.multipart.FileUpload;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        //  Amazon sayfasına gidelim tum sayfanın resmini alalım
        driver.get("https://www.trendyol.com");

        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz.
        */

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(formatter);
        System.out.println(date);
        System.out.println(tarih);

        String Url = driver.getCurrentUrl().substring(12);
        System.out.println(Url);
        String format = Url.concat(tarih);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/"+format+".jpeg"));


    }
}
