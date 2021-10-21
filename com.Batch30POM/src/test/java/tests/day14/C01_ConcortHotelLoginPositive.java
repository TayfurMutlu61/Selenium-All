package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHatelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {
    //1 ) Bir Class olustur : PositiveTest
    //2) Bir test method olustur positiveLoginTest()
    @Test
    public void positiveLoginTest(){


        // https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");

        ConcortHatelPage concortHatelPage=new ConcortHatelPage(driver);
        // login butonuna bas
        concortHatelPage.ilkLoginLinki.click();

        // test data username: manager ,
        concortHatelPage.userNameKutusu.sendKeys("manager");

        // test data password : Manager1!
        concortHatelPage.passwordKutusu.sendKeys("Manager1!");
        concortHatelPage.loginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHatelPage.basariliTesti.isDisplayed());

    }
}
