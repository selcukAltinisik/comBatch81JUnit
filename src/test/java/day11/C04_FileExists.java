package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists {

    @Test
    public void test1() {
/*

        System.out.println(System.getProperty("user.dir"));
        // Şu anki içinde bulunduğumuz yolu gösterir.

        System.out.println(System.getProperty("user.home"));
        //Geçerli kullanıcının ana dizinini verir

        String farkliBolum = System.getProperty("user.home");
        //  "C:\Users\selcu\Desktop\text.txt"   --> masaüstündeki dosyanın yolu

        String ortakBolum = "\\Desktop\\text.txt";

        String masaUstuDosyaYolu = farkliBolum+ortakBolum;  //  Masaüstündeki dosya yolunu gösterir.

        System.out.println(masaUstuDosyaYolu);  //  C:\Users\selcu\Desktop\text.txt
        System.out.println(Files.exists(Path.of(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Path.of(masaUstuDosyaYolu)));

 */

        String dosyaYolu = "C:\\Users\\selcu\\Desktop\\text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        Bir web sitesinden indirdiğimiz ya da windows içinde oluşturduğumuz dosyanınindiğini ya da orada olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılıolarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir String değişkene atarız ve dosyayı doğrulamak için
            Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu method'u kullanırız.

         */


    }
}
