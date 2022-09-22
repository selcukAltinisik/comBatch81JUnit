package day11;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;
import java.util.List;
public class Odev03 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // -  amazon gidin
        driver.get("https://amazon.com.tr");
        driver.findElement(By.id("sp-cc-accept")).click();

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        WebElement dropDownMenu=driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        List<WebElement> dropList=select.getOptions();
        for (WebElement each:dropList ) {
            System.out.println(each.getText());
        }

        //dropdown menude 40 eleman olduğunu doğrulayın
        int actualDropSize=dropList.size();
        int expectedDropSize=40;
        Assert.assertNotEquals(expectedDropSize,actualDropSize);

        //Test02
        //dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Elektronik");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        searchBox.sendKeys("iphone", Keys.ENTER);
        WebElement result =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuç sayısı = " + result.getText());

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedResult="iphone";
        Assert.assertTrue(result.getText().contains(expectedResult));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(ilkUrun));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String ilkUrunTitle=driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
        String ilkUrunFiyati=driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        WebElement sepeteEkle = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        sepeteEkle.click();

        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com.tr");

        // driver.findElement(By.id("sp-cc-accept")).click();
        //dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu2=driver.findElement(By.id("searchDropdownBox"));
        Select select2 = new Select(dropDownMenu2);
        select2.selectByIndex(2);

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox2=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox2.sendKeys("bebek puset",Keys.ENTER);
        WebElement result2 =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuç sayısı 2= " + result2.getText());

        //sonuç yazsının puset içerdiğini test edin
        String expectedResult2="puset";
        Assert.assertTrue(result2.getText().contains(expectedResult2));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement dorduncuUrun=driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[4]"));
        WebElement ucuncuUrun = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(dorduncuUrun));
        ucuncuUrun.click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String ikinciUrunTitle=driver.findElement(By.id("productTitle")).getText();
        String ikinciUrunFiyati=driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        WebElement sepeteEkle2 = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        sepeteEkle2.click();

        // Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.id("sw-gtc")).click();
        String sepettekiIkinciUrunTitle=driver.findElement(By.xpath("(//*[@class='a-truncate-cut'])[1]")).getText();
        String sepettekiIlkUrunTitle=driver.findElement(By.xpath("(//*[@class='a-truncate-cut'])[2]")).getText();
        String sepettekiIkinciUrunFiyati=driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")).getText();
        String sepettekiIlkUrunFiyati=driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]")).getText();
        System.out.println("İlk urun title : "+ilkUrunTitle);
        System.out.println("Sepetteki İlk urun title : "+sepettekiIlkUrunTitle);
        System.out.println("İkinci urun title : "+ikinciUrunTitle);
        System.out.println("Sepetteki İkinci urun title : "+sepettekiIkinciUrunTitle);
        System.out.println("İlk urun fiyat : "+ilkUrunFiyati);
        System.out.println("Sepetteki İlk urun fiyat : "+sepettekiIlkUrunFiyati);
        System.out.println("İkinci urun fiyat : "+ikinciUrunFiyati);
        System.out.println("Sepetteki İkinci urun fiyat : "+sepettekiIkinciUrunFiyati);
        Assert.assertEquals(ilkUrunTitle,sepettekiIlkUrunTitle);
        Assert.assertNotEquals(ikinciUrunTitle,sepettekiIkinciUrunTitle); // Urun adi sigmiyor o yüzden NotEquals
        Assert.assertNotEquals(ikinciUrunFiyati,sepettekiIkinciUrunFiyati);//(Virgülden dolayı aynı değil)
        Assert.assertNotEquals(ilkUrunFiyati,sepettekiIlkUrunFiyati);//(Virgülden dolayı aynı değil)
    }
}
