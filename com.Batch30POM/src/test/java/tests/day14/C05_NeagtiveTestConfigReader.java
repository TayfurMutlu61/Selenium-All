package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHatelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NeagtiveTestConfigReader extends TestBase {

    @Test
    public void test(){
        //https://www.concorthotel.com/  adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        //login butonuna bas
        ConcortHatelPage concortHatelPage=new ConcortHatelPage(driver);
        concortHatelPage.ilkLoginLinki.click();
        //test data username=manager
        concortHatelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        //test data password = manager1
        concortHatelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        //degerleri girildiginde sayfaya girilmedigini test et
        concortHatelPage.loginButonu.click();
        Assert.assertTrue(concortHatelPage.isLoginFailed.isDisplayed());
    }

}
