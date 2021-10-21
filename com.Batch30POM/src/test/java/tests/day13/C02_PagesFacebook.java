package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPages;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

   @Test
    public void test(){
       // facebook login sayfasina gidin
       driver.get("https://www.facebook.com");
       FacebookPages facebookPage= new FacebookPages(driver);
      // page sayfasinda coocies i gec methodu oluturun
       facebookPage.coociesGecMetodu();
       // kullanici adi : techproed@hotmail.com
       facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");
       // sifre : 12345
       facebookPage.sifreKutusu.sendKeys("12345");
       facebookPage.girisButonu.click();

      // yazdigimizda giris yapamadigimizi test edin
      Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

   }

}
