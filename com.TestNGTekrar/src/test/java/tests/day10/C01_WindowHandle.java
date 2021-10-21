
package tests.day10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utulities.Database;

import java.util.Set;

public class C01_WindowHandle extends Database {

    @Test
    public void test(){
        //●Tests package’inda yeni bir class olusturun: D13_ WindowHandle 2
        //●https://the internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText="Opening a new window";
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualText,expectedText,"text dogrulanmadi");

        //●Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"baslik doghrulanmadi");
        //●Click Here butonuna basın.
        String ilkSayfaHandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> tuplamHandle= driver.getWindowHandles();

        String ikinciHaandle="";
        for (String each:tuplamHandle) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciHaandle=each;
            }
        }

        //●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciHaandle);

        String actualIkinciSayfaTitle= driver.getTitle();
        String expectedIkinciSayfaTitle="New Window";
        softAssert.assertEquals(actualIkinciSayfaTitle,expectedIkinciSayfaTitle,"ikinci sayfa title lar dogrulanmadi");
        //●Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualikinciSayfaText=driver.findElement(By.xpath("//h3")).getText();
        String expectedIkinciSayfaText="New Window";
        softAssert.assertEquals(actualikinciSayfaText,expectedIkinciSayfaText,"ikinci sayfa textleri dogrulanmadi");
        //●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);


        actualTitle= driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"baslik doghrulanmadi");
        softAssert.assertAll();
    }

}
