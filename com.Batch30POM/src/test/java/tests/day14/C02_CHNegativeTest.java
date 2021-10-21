package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHatelPage;
import utilities.TestBase;

public class C02_CHNegativeTest extends TestBase {
    @Test
    public void negativeTest(){
        //Bir test method olustur NegativeLoginTest()
        // https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");
        ConcortHatelPage concortHatelPage=new ConcortHatelPage(driver);
        // login butonuna bas
        concortHatelPage.ilkLoginLinki.click();

        // test data username: manager1 ,
        concortHatelPage.userNameKutusu.sendKeys("manager");
        // test data password : manager1!
        concortHatelPage.passwordKutusu.sendKeys("manager!");
        concortHatelPage.loginButonu.click();
        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHatelPage.isLoginFailed.isDisplayed());

    }
}
